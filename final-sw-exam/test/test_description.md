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
    - note: some of the assignment doesn't exist
- test 3
    - requirement: the RankingStrategy might change
    - base on sample2
    - extra: if `assignment` command appears after peer review, print `Error`
- test 4
    - assignment for same people -> error
    - duplicate criterion -> error
    - IO exception -> error
- test 5
  - if error happen before peer review -> error, end
- test 6
  - requirement: assignment errors
  - base on sample1
- test 7
  - requirement: multiple assignments
  - base on sample1

## Naming Convention

### notation

- n: index of sample test case
- m: index of assignment
- (TOO COMPLICATED) a_b: the peer review to student a from student b

### complicated

- `sample{n}.in`: the input file of n-th sample test case
- `sample{n}.out`: the output file of n-th sample test case
- `criteria{n}_{m}.txt`: the criteria file of the m-th assignment, n-th sample
- (TOO COMPLICATED) `score{n}_{m}_{a_b}.txt`: the peer review file to student a from student b, m-th assignment, n-th
  sample  