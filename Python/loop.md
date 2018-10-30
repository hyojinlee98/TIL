## 반복문

### for문
반복 횟수가 정해져있을 때 사용

사용 방법은 아래와 같다
``` python
for 변수 in range(시작값, 끝값 + 1, 증가값) :
```

``` python
for i in range(0, 3, 1) :
	print("%d" % i)
```

``` python
for i in range(0, 3) :
	print("%d" % i)
```

``` python
for i in range(3) :
	print("%d" % i)
```

``` python
for i in [0, 1, 2] :
	print("%d" % i)
```
##### Output
```
0
1
2
```

#### 1부터 100까지의 합 구하기

``` python
hap = 0

for i in range(1, 101) :
	hap = hap + i
print("1부터 100까지의 합 : %d" % hap)
```

##### Output
```
1부터 100까지의 합 : 5050
```

#### 구구단
``` python
for i in range(2, 10) :
    print("=== %d단 ===" % i, end="\t")
print("\n")
        
for i in range(1, 10) :  
    for j in range(2, 10) :
        print("%d X %d = %2d" % (j, i, i * j), end="\t")
    print()
```

##### Output
```
=== 2단 ===	=== 3단 ===	=== 4단 ===	=== 5단 ===	=== 6단 ===	=== 7단 ===	=== 8단 ===	=== 9단 ===	

2 X 1 =  2	3 X 1 =  3	4 X 1 =  4	5 X 1 =  5	6 X 1 =  6	7 X 1 =  7	8 X 1 =  8	9 X 1 =  9	
2 X 2 =  4	3 X 2 =  6	4 X 2 =  8	5 X 2 = 10	6 X 2 = 12	7 X 2 = 14	8 X 2 = 16	9 X 2 = 18	
2 X 3 =  6	3 X 3 =  9	4 X 3 = 12	5 X 3 = 15	6 X 3 = 18	7 X 3 = 21	8 X 3 = 24	9 X 3 = 27	
2 X 4 =  8	3 X 4 = 12	4 X 4 = 16	5 X 4 = 20	6 X 4 = 24	7 X 4 = 28	8 X 4 = 32	9 X 4 = 36	
2 X 5 = 10	3 X 5 = 15	4 X 5 = 20	5 X 5 = 25	6 X 5 = 30	7 X 5 = 35	8 X 5 = 40	9 X 5 = 45	
2 X 6 = 12	3 X 6 = 18	4 X 6 = 24	5 X 6 = 30	6 X 6 = 36	7 X 6 = 42	8 X 6 = 48	9 X 6 = 54	
2 X 7 = 14	3 X 7 = 21	4 X 7 = 28	5 X 7 = 35	6 X 7 = 42	7 X 7 = 49	8 X 7 = 56	9 X 7 = 63	
2 X 8 = 16	3 X 8 = 24	4 X 8 = 32	5 X 8 = 40	6 X 8 = 48	7 X 8 = 56	8 X 8 = 64	9 X 8 = 72	
2 X 9 = 18	3 X 9 = 27	4 X 9 = 36	5 X 9 = 45	6 X 9 = 54	7 X 9 = 63	8 X 9 = 72	9 X 9 = 81
```

### while 문
반복 횟수가 정해져있지 않고, 조건을 통해 반복할 경우 사용

사용 방법은 아래와 같다
```
while 조건 :
```

``` python 
i = 0
while i < 3 :
	print(i)
	i = i + 1
```

##### Output
```
0
1
2
```

#### 1부터 100까지의 합 구하기
``` python
i, hap = 1, 0
while i < 101 :
	hap = hap + i
	i = i + 1
print("1부터 100까지의 합 : %d" % hap)
```
##### Output
```
1부터 100까지의 합 : 5050
```

