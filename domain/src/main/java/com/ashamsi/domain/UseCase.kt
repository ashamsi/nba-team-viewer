package com.ashamsi.domain

/**
 * Contract for use case.
 *
 * @param Type The return type which is the result of the executed use case.
 * @param Params The parameters with extra data for the use case.
 */
interface UseCase<out Type, in Params> where Type : Any {
    suspend fun execute(vararg args: Params): Type
}