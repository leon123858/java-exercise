# Test Description

## Test Goal
each test has its own purpose
- test 1
  - simple
  - 4 students, 1 assignment, 4 criteria, 3 Levels 
- test 2
  - requirement: the levels and scores might change
  - 5 students, 1 assignment, 4 criteria, 4 Levels
  - note: some of the student will not get scored

## Naming Convention
### notation
- n: index of sample test case
- m: index of assignment
- (TOO COMPLICATED) a_b: the peer review to student a from student b 

### complicated
- `sample{n}.in`: the input file of n-th sample test case
- `sample{n}.out`: the output file of n-th sample test case
- `criteria{n}_{m}.txt`: the criteria file of the m-th assignment, n-th sample
- (TOO COMPLICATED) `score{n}_{m}_{a_b}.txt`: the peer review file to student a from student b, m-th assignment, n-th sample  