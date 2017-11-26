# Timetable optimization problem
## Input:
* n - number of available meetings
* sTime - start time of meeting(in minutes)
* duration - duration of meetings
### --------------
## Input format:
n

sTime duration

sTime duration

...

sTime duration

\--------------
## Output
* list of optimum number of non-time-conflicted meetings with their sTime and duration
* a number of meetings in output
### --------------
## Example input:
TimeTable Optimizer
 
Enter number of available meetings and starting minute and duration for each

5

0 1440

2 10

3 13

13 10

25 10

\--------------
## Example output
Received list of meetings: 

Start time: 2 | Duration: 10

Start time: 3 | Duration: 13

Start time: 13 | Duration: 10

Start time: 25 | Duration: 10

Start time: 0 | Duration: 1440

\--------------

Computed optimized timetable: 

Start time: 2 | Duration: 10

Start time: 13 | Duration: 10

Start time: 25 | Duration: 10

\--------------

Number of meetings: 3

  
Process finished with exit code 0

