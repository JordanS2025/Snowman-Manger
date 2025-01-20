// Jordan Scott
// CSt-416
// 1/18/2025
// This is my own work.

import java.time.LocalDate

fun main(args: Array<String>) {
    println("Welcome to Snowman Manager! Choos one of the following actions:")
    println("=========================")

    // Correcting the constructor call syntax
    val man1 = SnowMan(
        ID = 1,
        name = "Frosty",
        hasTopHat = false,
        dateOfBirth = LocalDate.parse("1952-12-25"),
        weight = 88.1F
    )
    // create a new list and add Frosty as the default snowman
    var SnowManList = mutableListOf<SnowMan>()
    SnowManList.add(man1)

    var userchoice = 0

    while (userchoice != 9)
    {
        println("Please choose an option:")
        println(" 1.\tAdd a new snowman to the inventory\n" +
                "2.\tDisplay all snowmen in the inventory.\n" +
                "3. \tShow a single snowman given its id number\n" +
                "4. \tSearch for a snowman by (partial) name\n" +
                "5. \tDelete a snowman\n" +
                "6. \tChange a snowman\n" +
                "9.\tQuit the program\n")
        userchoice = Integer.parseInt(readln())

        when (userchoice)
        {
            1 -> {
                // add a new snowman
                println("Enter the name of the snowman:")
                val name = readln()
                println("Does the snowman have a top hat? (true/false)")
                val hasTopHat = readln().toBoolean()
                println("Enter the date of birth (yyyy-mm-dd):")
                val dateOfBirth = LocalDate.parse(readln())
                println("Enter the weight of the snowman:")
                val weight = readln().toFloat()

                // store the new snowman in the list
                SnowManList.add(SnowMan(SnowManList.size + 1, name, hasTopHat, dateOfBirth, weight))
                println("Snowman added successfully!")
                println("================================")

            }
            2 -> {
                // display all snowmen
                println("Displaying all snowmen")
                SnowManList.forEach ( { it: SnowMan -> println("Here is a snowman: ${it.name}") } )
                println("================================")
            }
            3 -> {
                // display a single snowman
                println("Enter the ID of the snowman you want to display:")
                val id = readln().toInt()
                val snowman = SnowManList.find { it.ID == id }
                if (snowman != null) {
                    println("Here is a snowman: ${snowman.name}, " +
                            "hasTopHat: ${snowman.hasTopHat}, " +
                            "dateOfBirth: ${snowman.dateOfBirth}, " +
                            "weight: ${snowman.weight}")
                    println("================================")
                } else {
                    println("Snowman not found.")
                }
            }
            4 -> {
                // search for a snowman
                println("Enter the name of the snowman you want to search for:")
                val name = readln()
                val snowman = SnowManList.find { it.name.contains(name, ignoreCase = true) }
                if (snowman != null) {
                    println("Here is a snowman: ${snowman.name}")
                    println("================================")
                } else {
                    println("Snowman not found.")
                }
            }
            5 -> {
                // delete a snowman
                println("Enter the ID of the snowman you want to delete:")
                val id = readln().toInt()
                val removed = SnowManList.removeIf { it.ID == id }
                if (removed) {
                    println("Snowman deleted successfully!")
                } else {
                    println("Snowman not found.")
                }
                println("================================")
            }
            6 -> {
                // change a snowman
                println("Enter the ID of the snowman you want to change:")
                val id = readln().toInt()
                // What would you like to change?
                println("What would you like to change?")
                println("1. Name")
                println("2. Has top hat")
                println("3. Date of birth")
                println("4. Weight")
                val choice = readln().toInt()
                when (choice) {
                    1 -> {
                        // change the name
                        println("Enter the new name:")
                        val name = readln()
                        val snowman = SnowManList.find { it.ID == id }
                        if (snowman != null) {
                            snowman.name = name
                            println("Snowman updated successfully!")
                        } else {
                            println("Snowman not found.")
                        }
                    }
                    2 -> {
                        // change the hasTopHat
                        println("Does the snowman have a top hat? (true/false)")
                        val hasTopHat = readln().toBoolean()
                        val snowman = SnowManList.find { it.ID == id }
                        if (snowman != null) {
                            snowman.hasTopHat = hasTopHat
                            println("Snowman updated successfully!")
                        } else {
                            println("Snowman not found.")
                        }
                    }
                    3 -> {
                        // change the date of birth
                        println("Enter the new date of birth (yyyy-mm-dd):")
                        val dateOfBirth = LocalDate.parse(readln())
                        val snowman = SnowManList.find { it.ID == id }
                        if (snowman != null) {
                            snowman.dateOfBirth = dateOfBirth
                            println("Snowman updated successfully!")
                        } else {
                            println("Snowman not found.")
                        }
                        println("================================")
                    }
                    4 -> {
                        // change the weight
                        println("Enter the new weight:")
                        val weight = readln().toFloat()
                        val snowman = SnowManList.find { it.ID == id }
                        if (snowman != null) {
                            snowman.weight = weight
                            println("Snowman updated successfully!")
                        } else {
                            println("Snowman not found.")
                        }
                    }
                }
            }
            9 -> {
                // quit the program
                println("Goodbye!")
            }
        }
    }
}