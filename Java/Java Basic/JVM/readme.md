# [Java] - JVM

작성일시: 2023년 9월 11일 오후 12:45
복습: No

## JVM 구조

📌 JVM은 자바 언어 뿐만아니라 코틀린, 스칼라 언어에서도 작동방식을 그대로 따른다.

📌 JVM을 정확히 이해하면 모던 언어를 이해하는데 있어 수월하며 내부에서 코드가 실행되는 개념과 코드 최적화 , 리팩토링에 매우 도움이 된다.

![Untitled](https://github.com/Sunro1994/TotalRepository/assets/132982907/8ed98228-1d9f-4e37-932d-a5633e07e1d3)
📌JVM 이 .class 파일을 어떠한 처리를 거쳐 프로그램을 실행하는지 알아보자.

## 자바 가상 머신의 동작 방식

1. 자바 프로그램을 실행하면 JVM은 OS로부터 메모리를 할당받는다.
2. 자바 컴파일러(javac)가 자바 소스코드(.java)를 자바 바이트 코드(.class)로 컴파일 한다.
3. Class Loader는 동적 로딩을 통해 필요한 클래스 및 링크하여 Runtime Data Area(실질적인 메모리를 할당 받아 관리하는 영역)에 올린다.
4. Runtime Data Area에 로딩 된 바이트 코드는 Execution Engine을 통해 해석된다.
5. Execution Engine에 의해 GC의 작동과 Thread의 동기화가 이루어진다.

![Untitled 1](https://github.com/Sunro1994/TotalRepository/assets/132982907/afb42e47-ba42-47fa-8145-cbe304a793a1)
## 자바 가상 머신(JVM)의 구조

📌클래스 로더(Class Loader)

📌실행 엔진(Execution Engine)

✅ 인터프리터

✅ JIT(Just-In-Time) 컴파일러

✅가비지 컬렉터(Garbage Collector)

📌런타임 데이터 영역(Runtime Data Area)

✅ 메서드 영역

✅ 힙 영역

✅ PC Register

✅ 스택

✅ Native Method

📌 JNI - Native Method Interface

📌 Native Method Library

![Untitled 2](https://github.com/Sunro1994/TotalRepository/assets/132982907/b8207bfe-6648-4dbe-8768-338deaeb6510)
## 클래스 로더(Class Loader)

![Untitled 3](https://github.com/Sunro1994/TotalRepository/assets/132982907/e35c6970-421c-4aef-9bc7-b6808e543666)
📌클래스 로더는 JVM내로 클래스 파일(*.class)을 동적으로 로드하고, 링크를 통해 배치하는 작업을 수행하는 모듈

📌로드된 바이트 코드들을 엮어서 JVM의 메모리 영역인 Runtime Data Area에 배치한다.

- [ ]  클래스 파일의 로딩 순서
    
    📌Loading → Linking → Initialization
    
    📌 Load : 클래스 파일을 가져와서 JVM의 메모리에 로드
    
    📌 Linking
    
    1. Verifying(검증) : 읽어들인 클래스가 JVM명세에 명시된 대로 구성되어 있는지 검사
    2. Preparing(준비) : 클래스가 필요로 하는 메모리를 할당
    3. Resolving(분석) : 클래스의 상수 풀 내 모든 심볼릭 레퍼런스를 다이렉트 레퍼런스로 변경
    
    📌 Initialization : 클래스 변수들을 적절한 값으로 초기화(static필드들을 설정된 값으로 초기화 등)
    
![Untitled 4](https://github.com/Sunro1994/TotalRepository/assets/132982907/a895915f-6272-4926-8c2e-d3bc4a704268)    

## 실행 엔진(Execution Engine)

📌실행 엔진은 클래스 로더를 통해 런타임 데이터 영역에 배치된 바이트 코드를 명령어 단위로 읽어서 실행

📌 자바 바이트 코드는 기계가 바로 수행할 수 있는 언어보다는 가상머신이 이해할 수 있는 중간레벨로 컴파일 된 코드

📌 이와 같은 바이트 코드를 이용해서 JVM내부에서 기계가 실행될 수 있는 형태로 변경해준다.

📌 이 수행 과정에서 실행 엔진은 인터프리터와 JIT 컴파일러 두가지 방식을 혼합하여 바이크 코드를 실행한다.

![Untitled 5](https://github.com/Sunro1994/TotalRepository/assets/132982907/08c467aa-35c7-456d-bfe2-a98eca64652f)
## 인터프리터

📌바이트 코드 명령어를 하나씩 읽어서 해석하고 바로 실행

JVM안에서 바이트코드는 기본적으로 **`인터프리터 방식`**으로 동작한다.

다만 같은 메서드라도 여러번 호출된다면 매번 해석하고 수행해야 되서 전체적인 속도는 느리다.

## Native Code

📌 Java에서 부모가 되는 C언어, C++, Assembly언어로 구성된 코드

## JIT 컴파일러 (Just- In - Time 컴파일러)

📌 Interpretor의 단점을 보완하기 위해 도입된 방식으로 반복되는 코드를 발견하여 바이트 코드 전체를 컴파일하여 Native Code로 변경하고 이후에는 해당 메서드를 더이상 인터프리팅하지않고 캐싱해두었다가 네이티브 코드로 직접 실행하는 방식

📌 전체적인 실행 속도는 인터프리팅 방식보다 빠르다. 하나씩 실행하는 것이 아닌 컴파일된 네이티브 코드를 실행하는 것이기 때문

📌 하지만 바이트코드를 Native Code로 변환하는데 비용이 소요되므로, JVM은 모든 코드를 JIT컴파일러 방식으로 실행하지 않고 인터프리터 방식을 사용하다 **일정 기준이 넘어가면** JIT 컴파일 방식으로 명령어를 실행하는 방식으로 진행

## 가비지 컬렉터(Garbage Collector, GC)

📌 JVM은 가비지 컬렉터(garbage collector)를 이용하여 Heap 메모리 영역에서 더는 사용하지 않는 메모리를 자동으로 회수 해준다.

📌 Full GC가 발생하는 경우, GC를 제외한 모든 스레드가 중지되기 때문에 장애가 발생할 수 있다.

## 런타임 데이터 영역(Runtime Data Area)

![Untitled 6](https://github.com/Sunro1994/TotalRepository/assets/132982907/b48a191c-409e-48b1-b049-52c78898f031)
런타임 데이터 영역은 JVM 메모리 영역으로 자바 애플리케이션을 실행할 때 사용되는 데이터들을 적재하는 영역

✅Method(Static) 

📌 JVM에서 읽어들인 클래스와 인터페이스에 대한 런타임 상수 풀, 메서드와 필드, static변수, 메서드 바이트 코드 등을 보관

✅Runtime Constant Pool

📌 Method Area 영역에 포함되지만 독자적 중요성을 띈다.

📌 클래스 파일 constant_pool 테이블에 해당하는 영역

📌 클래스와 인터페이스 상수, 메서드와 필드에 대한 모든 레퍼런스 저장

📌 JVM은 런타임 상수 풀을 통해 해당 메서드나 필드의 실제 메모리 상 주소를 찾아 참조

✅Heap Area

📌프로그램 상에서 데이터를 저장하기 위해 런타임 시 동적으로 할당하여 사용하는 메모리 영역

📌 New 연산자를 통해 생성한 객체, 또는 인스턴스와 배열 저장

📌 JVM이 관리

❗Method와 Heap Area는 모든 스레드에서 공유한다.

✅Stack Area

📌 FILO 구조, 메서드 호출 시 생성되는 스레드 수행정보를 기록하는 Frame저장, 메서드 정보, 지역변수, 매개변수, 연산 중 발생하는 임시 데이터 저장
📌{}나 메서드가 끝날 때

✅PC 레지스터

📌 현재 실행중인 JVM구조를 가지고 있다.

📌 cpu 명령어 즉 instruction을 수행한다.

📌 cpu instruction 수행하는 동안 필요한 정보를 cpu내 기억장치인 레지스터에 저장

📌 연산 및 결과값을 메모리에 전달하기 전 cpu내 기억장치임

✅Native Method Stack Area

📌 자바 외 언어로 작성된 네이티브 코드를 위한 메모리

📌 C/C++ 등의 코드를 수행하기 위한 스택

📌 native 메서드의 매개변수, 지역변수 등을 바이트 코드로 저장

📌 native inteface 호출 시 생성

📌 native interface 종료 시 생성

❗Stack, PC register, Native Method Stack Area는 각 스레드별로 생성된다.

✅위 내용을 도식화한 그림

![Untitled 7](https://github.com/Sunro1994/TotalRepository/assets/132982907/0fb5922d-c58b-47e4-bd81-d289065a0441)
## 메서드 영역(Method 영역) (=Class Area, Static Area)

📌JVM이 시작될 때 생성되는 공간으로 바이트코드를 처음 메모리 공간에 올릴때 초기화되는 대상을 저장하기 위한 메모리 공간

📌JVM이 동작하고 클래스가 로드될 때 적재되서 프로그램이 종료될때까지 저장된다.

📌모든 쓰레드가 공유하는 영역으로 다음 초기화 코드 정보들이 저장된다.

1. Field Info : 멤버 변수의 이름, 데이터 타입, 접근 제어자의 정보
2. Method Info : 메서드의 이름, return 타입, 함수 매개변수, 접근 제어자의 정보
3. Type Info : Class인지 Interface인지 여부 저장, Type의 속성, 이름 Super Class의 이름

📌 메서드 영역에서는 정적 필드와 클래스 구조만을 갖고 있다고 할 수 있다.

📌 메서드 영역/ 런타임 상수 풀의 사용기간 및 스레드 공유 범위 : JVM 시작시 생성, 프로그램 종료시까지, 명시적으로 NULL 선언 시

## Runtime Constant Pool

📌 메서드 영역에 존재하는 별도의 관리영역

📌 각 클래스/인터페이스마다 별도의 constant pool테이블이 존재하는데, 클래스 생성시 참조해야 할 정보들을 상수고 가지고 있는 영역이다.

📌 JVM은 이 상수풀을 통해 해당 메서드나 필드의 실제 메모리 상 주소를 찾아 참조한다.

📌 **상수 자료형을 저장하고 참조하여 중복을 막는 역할을 한다.**

## 힙 영역(Heap Area)

📌메서드 영역과 함께 모든 쓰레드가 공유

📌 JVM이 관리하는 프로그램 상에서 데이터를 저장하기 위해 런타임 시 동적으로 할당하여 사용하는 영역

📌 new 연산자로 생성되는 클래스와 인스턴스와 인스턴스 변수, 배열 타입 등 Reference Type이 저장되는 곳

📌 당연히 Method Area영역에 저장된 클래스만이 생성되어 적재된다.



![Untitled 8](https://github.com/Sunro1994/TotalRepository/assets/132982907/591248e4-ea21-4417-ac5c-ca00e0695352)
📌 메서드 영역/ 런타임 상수 풀의 사용기간 및 스레드 공유 범위 : 객체가 더 이상 사용되지 않거나 명시적으로 null 선언 시 ,GC 대상

📌 힙 영역에 생성된 객체와 배열은 Reference Type으로서, JVM 스택 영역의 변수나 다른 객체 필드에서 참조된다는 점이다. 즉, 힙의 참조 주소는 스택이 갖고 있고, 해당 객체를 통해서만 힙 영역에 있는 인스턴스를 핸들링 할 수 있다.


![Untitled 9](https://github.com/Sunro1994/TotalRepository/assets/132982907/f4ce5584-6be2-4522-94f4-9c1cbfc42ab1)
📌 만일 참조하는 변수나 필드가 없다면 의미가 없는 객체가 되기 때문에 이것을 쓰레기로 취급하고 JVM은 쓰레기 수집기인 G.C를 실행시켜 쓰레기 객체를 힙 영역에서 자동으로 제거된다.

📌 힙 영역은 가비지 컬렉션에 대상이 되는 공간이다.

효율적인 가비지 컬렉션을 수행하기 위해 세부적으로 다음과 같이 5가지 영역으로 나뉜다.

다섯가지 영역(Eden, survivor 0, survivor 1, Old, Permanent)로 나뉜 힙 영역은 다시 물리적으로 Young Generation과 Old Generation 영역으로 구분되게 된다.

✅Young Generation : 생명 주기가 짧은 객체를 GC대상으로 하는 영역

1. Eden : new 를 통해 생성된 객체가 위치, 정기적인 쓰레기 수집 후 살아남은 객체들은 survivor로 이동
2. Survivor 0 / 1 : 각 영역이 채워지게 되면, 살아남은 객체는 비워진 Survivor로 순차적으로 이동

✅Old Generation : 생명 주기가 긴 GC대상으로 하는 영역. Young Generation에서 끝까지 살아남은 객체가 이동


![Untitled 10](https://github.com/Sunro1994/TotalRepository/assets/132982907/f5f63479-655f-40bb-8a53-b531b5e459e8)
## 스택영역

📌 int, long , boolean 등 기본 자료형을 생성할 때 저장하는 공간으로, 임시적으로 사용되는 변수나 정보들이 저장되는 영역

📌 LIFO구조

📌 메서드 호출 시마다 각각의 스택 프레임(그 메서드만을 위한 공간)이 생성되고 메서드 안에서 사용되는 값을 저장하고, 호출된 메서드의 매개변수, 지역변수, 리턴 값 및 연산 시 일어나는 값들을 임시로 저장한다.

📌 메서드 수행이 끝나면 프레임별로 삭제된다.

✅스택 프레임

메서드가 호출될 때마다 프레임이 만들어지며, 현재 실행중인 메서드 상태 정보를 저장하는 곳

메서드 호출 범위가 종료되면 스택에서 삭제된다.

스택 프레임에 쌓이는 데이터는 메서드의 매개변수, 지역변수, 리턴값, 연산 시 결괏값등이 있다.

📌 단, 데이터의 타입에 따라 스택과 힙에 저장되는 방식이 다르다는 점은 유의해야 한다.

1. 기본(원시)타입 변수는 스택 영역에 직접 값을 가진다.
2. 참조타입 변수는 힙 영역이나 메서드 영역의 객체 주소를 가진다.


![Untitled 11](https://github.com/Sunro1994/TotalRepository/assets/132982907/cdc4bece-ca30-49cf-bf7d-0bc9b7da5543)
📌스택 영역은 각 스레드마다 하나씩 존재하며, 스레드가 시작될 때 할당된다.

📌 프로세스가 메모리에 로드 될 때 스택 사이즈가 고정되어 있어, 런타임 시에 스택 사이즈를 바꿀 수는 없다.

📌 쓰레드를 종료하면 런타임 스택도 사라진다.

![Untitled 12](https://github.com/Sunro1994/TotalRepository/assets/132982907/fd4cf7fe-d1e3-4e77-aef8-b36836bac0b4)
## 지금까지 배운 영역들을 도식화


![Untitled 13](https://github.com/Sunro1994/TotalRepository/assets/132982907/bc2a3a06-84e3-4342-8826-577538aec394)