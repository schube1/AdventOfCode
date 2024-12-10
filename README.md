# Advent of Code 2024
Source code solutions to Advent of Code daily problems. 

Day 1

Problem Statement:
Given 2 lists of ints Pair up the smallest number in the left list with the smallest number in the right list, then the second-smallest left number with the second-smallest right number, and so on.


Intuition:
Sort each list 
Pop the top off both 
Compete abs.(a[min] -b[min])
Add to total
Return total


Day 2

Problem:
The task is to analyze reports containing numeric levels to determine which are safe. A report is safe if all levels are either strictly increasing or strictly decreasing, with adjacent differences between 1 and 3. The goal is to count how many reports meet these criteria.


Intuition: 
Iterate through file while it contains another line
String [] of numbers split using whitespace
If the size is > than 1 create arr[size]
Call func to check if that arr follows inc or dec pattern (abs.(max diff) = 3)
Return inc || dec
