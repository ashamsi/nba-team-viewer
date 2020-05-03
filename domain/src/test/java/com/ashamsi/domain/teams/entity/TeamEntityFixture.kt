package com.ashamsi.domain.teams.entity

object TeamEntityFixture {
    private val playerOne = PlayerEntity(1, "A", "B", "SG", 1)
    private val playerTwo = PlayerEntity(2, "D", "E", "C", 2)
    private val playerThree = PlayerEntity(3, "F", "G", "SG", 3)

    private val players = listOf(playerOne, playerTwo, playerThree)

    private val teamOne = TeamEntity(1, "Boston Celtics", 45, 20, players)
    private val teamTwo = TeamEntity(2, "New York Knicks", 24, 40, players)
    private val teamThree = TeamEntity(3, "Philadelphia 76ers", 34, 28, players)
    private val teamFour = TeamEntity(4, "Toronto Raptors", 45, 17, players)
    private val teamFive = TeamEntity(5, "Chicago Bulls", 21, 42, players)


    val initialTeams = listOf(teamOne, teamTwo, teamThree, teamFour, teamFive)
    val sortedByWinsTeams = listOf(teamOne, teamFour, teamThree, teamTwo, teamFive)
    val sortedByLossesTeams = listOf(teamFour, teamOne, teamThree, teamTwo, teamFive)
    val sortedByNameAsc = listOf(teamOne, teamFive, teamTwo, teamThree, teamFour)
    val sortedByNameDesc = listOf(teamFour, teamThree, teamTwo, teamFive, teamOne)

}