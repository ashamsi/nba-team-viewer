package com.ashamsi.data.retrorit

import com.ashamsi.data.teams.model.TeamModel
import com.ashamsi.domain.util.SystemLogUtils
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.io.File
import java.util.concurrent.TimeUnit

private const val HOST = "https://raw.githubusercontent.com/scoremedia/nba-team-viewer/master/"
private const val TAG = "RetrofitApiService"

interface ApiService {
    @GET("input.json")
    suspend fun getTeams(): Response<List<TeamModel>>
}

class ApiFactory(private val isConnected: Boolean, cacheDir: File) {
    private val cacheSize = (5 * 1024 * 1024).toLong() // 5MB
    private val cache = Cache(cacheDir, cacheSize)

    private val loggingInterceptor = Interceptor { chain ->
        val request = chain.request()
        SystemLogUtils.d(TAG, "OkHttp: ${request.url()}")
        chain.proceed(request)
    }

    private val offlineCacheInterceptor = Interceptor { chain ->
        val request = chain.request()
        if (!isConnected) {
            request.newBuilder().cacheControl(CacheControl.FORCE_CACHE)
        }
        chain.proceed(request)
    }

    private val okHttpClient = OkHttpClient.Builder()
            .cache(cache)
            .connectTimeout(5L, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(offlineCacheInterceptor)
            .build()

    private val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(HOST)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}