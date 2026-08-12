# Day 27 - N-Queens Introduction (Constraint Satisfaction Backtracking)

## Problem
Count the number of distinct solutions to the N-Queens problem for a given n.

## Concepts Covered
- Constraint satisfaction backtracking
- Row-by-row queen placement (eliminates row constraint by construction)
- O(1) conflict detection using column/diagonal boolean trackers
- Early pruning for efficiency
- Diagonal identification: row-col and row+col tricks

## Files
- Main.java

## Complexity
Time: Empirically fast due to pruning (loose bound O(n!)) | Space: O(n)