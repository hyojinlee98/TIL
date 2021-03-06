# [LOB] troll Write-up

![](./picture/troll_1.JPG)

```
login : orge
Password : timewalker
```

위의 계정으로 로그인하여 접속한다.

이번 문제의 소스코드는 다음과 같다.

![](./picture/troll_2.JPG)

argc가 2개여야 하고, buffer와 argv[1]을 초기화한다. 스택에서 남은 부분은 argv[0], 즉 파일 이름 뿐이다. 쉘코드로 된 이름의 파일로 심볼릭 링크를 걸어 실행하고, argv[0]의 시작 주소를 리턴 주소로 넣어주면 된다.

```
[orge@localhost orge]$ cp troll aaaaa
```

우선 파일을 복사하고, 복사한 파일에 쉘코드로 된 파일 이름으로 심볼릭 링크를 걸어준다. `\x2f`는 `/`를 의미하기 때문에 파일명에 해당 값이 들어가게 되면 디렉토리로 인식하게 된다. 디렉토리를 생성해주는 방법도 있지만 `\x2f`가 없는 쉘코드를 사용하는 방법을 사용했다.

```
\xeb\x11\x5e\x31\xc9\xb1\x32\x80\x6c\x0e\xff\x01\x80\xe9\x01\x75\xf6\xeb\x05\xe8\xea\xff\xff\xff\x32\xc1\x51\x69\x30\x30\x74\x69\x69\x30\x63\x6a\x6f\x8a\xe4\x51\x54\x8a\xe2\x9a\xb1\x0c\xce\x81
```

위의 쉘코드가 `\x2f`가 없는 48byte 쉘코드이다. 

![](./picture/troll_3.JPG)

심볼릭 링크는 `ln [옵션] 원본파일 대상파일` 형식으로 사용한다. 심볼릭 링크가 걸린 것을 볼 수 있다.

![](./picture/troll_4.JPG)

실행할 때 쉘코드로 된 이름으로 실행을 시키고 인자로 NOP 44byte 주고, RET가 bf로 시작하게 줬다. 리턴주소가 이상해서 core dump가 생겼다.

![](./picture/troll_5.JPG)

core 덤프 분석을 해보면 esp는 argc를 가리키고 있고, 그 다음이 argv이다. `0xbffffac4`를 보면 순서대로 argv[0], argv[1]이다. `0xbffffbb5`가 argv[0] 임을 알 수 있다.

![](./picture/troll_6.JPG)

심볼릭 링크를 삭제해주고, troll에 다시 걸어주었다. 심볼릭 링크 이름으로 실행하여 인자로 buffer+SFP(44byte)를 NOP으로 채워주고, RET에 argc[0]의 시작주소인 `0xbffffbb5`를 넣어주었다. 

![](./picture/troll_7.JPG)

비밀번호는 **aspirin** 이다.