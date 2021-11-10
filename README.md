# Seating Plan

Generates a seating plan with people from each group spread out across tables.

## Running the program

- Run the `main()` function and provide these arguments when prompted

  - The total number of tables
  - The number of seats on every table
  - The name of the CSV file containing the people and their group

## Algorithm

The program aims to assign people to each table based on their group. It first distributes the groups across the tables,
and then randomly chooses the people from the groups to be distributed

### Example:

Say the people and groups are:

```
| Name      | Group  |
----------------------
| Frodo     | Hobbit |
| Samwise   | Hobbit |
| Gandalf   | Wizard |
| Saruman   | Wizard |
| Galadriel | Elf    |

```

And say there are three tables, with each seating two people.

The algorithm first distributes the groups across the tables, placing people on the table with the least number of
people and the fewest number of groups:

```
         | Hobbit | Wizard | Elf  |
-----------------------------------         
Table 1  |   1    |    1   |   0  |
Table 2  |   1    |    0   |   1  |
Table 3  |   0    |    1   |   0  |
```

Then it assigns the person from a randomly shuffled list:

```
         | Hobbit  | Wizard  |    Elf    |
------------------------------------------         
Table 1  | Samwise | Gandalf |           |
Table 2  |  Frodo  |         | Galadriel |
Table 3  |         | Saruman |           |
```

## Issues

If the table capacity and number of tables is much larger than the number of people, then it awkardly produces tables
with only one person on each table.

Eg: 3 tables, seating 5, and there are only 4 people, the output would be

```
Table 1 => 2 people 
Table 2 => 1 person 
Table 3 => 1 person.
```


