# Conways Game of Life
A cellular automoaton developed by John Conway. It is a genetic algorithm that evolves where each generation/iteration is created using the following rules:

Any live cell with fewer than two live neighbours dies, as if by underpopulation.
Any live cell with two or three live neighbours lives on to the next generation.
Any live cell with more than three live neighbours dies, as if by overpopulation.
Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction