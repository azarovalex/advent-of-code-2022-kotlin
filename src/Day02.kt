enum class Move {
    ROCK, PAPER, SCISSORS;

    val points: Int
        get() = when (this) {
            ROCK -> 1
            PAPER -> 2
            SCISSORS -> 3
        }

    companion object {
        fun fromCharacter(char: String): Move {
            return when (char) {
                "A", "X" -> ROCK
                "B", "Y" -> PAPER
                "C", "Z" -> SCISSORS
                else -> throw IllegalArgumentException()
            }
        }
    }
}

fun outcome(ourMove: Move, opponentMove: Move): Int {
    if (ourMove == opponentMove) return 3
    return when {
        ourMove == Move.ROCK && opponentMove == Move.SCISSORS -> 6
        ourMove == Move.PAPER && opponentMove == Move.ROCK -> 6
        ourMove == Move.SCISSORS && opponentMove == Move.PAPER -> 6
        else -> 0
    }
}

fun moveForPredefinedOutcome(outcome: String, opponentMove: Move): Move {
    return when (outcome) {
        "Y" -> opponentMove
        "Z" -> when (opponentMove) {
            Move.ROCK -> Move.PAPER
            Move.PAPER -> Move.SCISSORS
            Move.SCISSORS -> Move.ROCK
        }
        "X" -> when (opponentMove) {
            Move.ROCK -> Move.SCISSORS
            Move.PAPER -> Move.ROCK
            Move.SCISSORS -> Move.PAPER
        }
        else -> throw IllegalArgumentException("Invalid outcome: $outcome")
    }
}

fun main() {
    fun part1(input: List<String>): Int {
        return input
            .map { line ->
                val moves = line.split(" ").map { Move.fromCharacter(it) }
                outcome(ourMove = moves[1], opponentMove = moves[0]) + moves[1].points
            }
            .sum()
    }

    fun part2(input: List<String>): Int {
        return input
            .map { line ->
                val components = line.split(" ")
                val opponentMove = Move.fromCharacter(components[0])
                val ourMove = moveForPredefinedOutcome(outcome = components[1], opponentMove)
                return@map outcome(ourMove, opponentMove) + ourMove.points
            }
            .sum()
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
