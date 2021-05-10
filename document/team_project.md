## [공학용 계산기]



### 1. 요구사항 분석 (Requirement Analysis)

- Java와 Android Studio를 이용한 공학용 계산기 구현



---

### 2. 구조 설계 (Structure Design)

#### 1) UML

**(1) Use Case Diagram**

<img src = "https://github.com/sanga327/Java_Project/tree/main/UML/Use Case Diagram.png?raw=true" width="80%">



**(2) Sequence Diagram**

<img src = "https://github.com/sanga327/Java_Project/tree/main/UML/Sequence Diagram.png" width="80%">



**(3) Class Diagram**

<img src = "https://github.com/sanga327/Java_Project/tree/main/UML/Class Diagram.png" width="80%">



#### 2) Class

- **InputOutput**

  - 입력받은 문자열을 저장하는 String, 연산자를 저장하는 ArrayList의 자료구조를 필드로 갖고 있다.
  - 각각의 문자열을 받아 하나의 문자열로 담는 메서드(input)를 포함한다.
  - 문자열을 배열 형태로 변환하는 메서드(str_to_array)를 포함한다.
  - Del, AC의 경우 문자열을 비우고 반환하는 메서드(delete)를 포함한다.

  

- **Calculate**

  - 후위 연산으로 만들기 위해 연산자 Stack, 피연산자 Stack, 입력받은 문자열 ArrayList, 후위 연산 표기법으로 변환한 문자열의 ArrayList의 자료구조를 필드로 갖고 있다. 
  - 연산자 우선순위를 결과로 반환하는 메서드(opPriority)를 포함한다.
  - 입력된 Array를 후위 연산식으로 만드는 메서드(postfixCalculation)를 포함한다.
  - 연산자에 따라 연산식을 수행하는 메서드(calculator)를 포함한다. 

  

- **Function**

  - 입력으로 들어오는 연산자에 따라 수식을 연산하는 기능을 포함한다.
  - 사칙연산(덧셈, 뺄셈, 나눗셈, 곱셈)을 구현하는 메서드를 포함한다. (sum, sub, mul, div)
  - 나머지(mod), 제곱(pow), 로그(log), 절댓값(abs), 팩토리얼(fac), 삼각함수(sin, cos, tan), 라디안(rad), 제곱근(root) 연산을 포함한다.

  

- **MainActivity **

  - Button 위젯의 id들을 선언, TextView 위젯의 id들을 선언, ScrollView 위젯의 id들을 선언한다.
  - double형태의 result, boolean형태의 toggle을 선언하고 있다.
  - Toggle 메서드, auto_Mul 메서드, onClick 메서드를 포함하고 있다.



#### 3) Function



- **InputOutput 내부 메서드**

|    method    | function                                                     |
| :----------: | :----------------------------------------------------------- |
|    input     | 입력된 수식(문자열)을 공백을 추가한 문자열로 반환한다.       |
| str_to_array | 입력된 문자열을 공백을 기준으로 ArrayList로 분리한다.        |
|    delete    | Del의 경우 문자열 배열의 마지막 값을 초기화한다. AC의 경우 문자열 전체를 초기화한다. |



- **Calculate 내부 메서드**

|       method       | function                                                     |
| :----------------: | :----------------------------------------------------------- |
|        init        | ArrayList로 선언된 output과 inputArr을 초기화하고 객체를 생성한다. |
|     opPriority     | 연산자 우선순위를 표시하는 메서드이다.                       |
| postfixCalculation | 입력된 수식(문자열)을 연산자와 피연산자로 분류하여 후위연산식으로 만든다. |
|     calculator     | 후위연산식으로 표기된 수식(ArrayList)에서 연산 순서에 따라 연산을 진행한다. |



- **Function 내부 메서드**

|    method    | function                                                     |
| :----------: | :----------------------------------------------------------- |
|     sum      | 입력된 숫자(피연산자) 2개를 사용해 덧셈한다.                 |
|     sub      | 입력된 숫자(피연산자) 2개를 사용해 뺄셈한다.                 |
|     mul      | 입력된 숫자(피연산자) 2개를 사용해 곱셈한다.                 |
|     div      | 입력된 숫자(피연산자) 2개를 사용해 나눗셈의 몫을 구한다.     |
|     mod      | 입력된 숫자(피연산자) 2개를 사용해 나눗셈의 나머지를 구한다. |
|     pow      | 입력된 숫자(피연산자) 2개를 사용해 제곱값을 구한다.          |
|     log      | 입력된 숫자(피연산자) 2개를 사용해 로그값을 구한다.          |
|     abs      | 입력된 숫자(피연산자) 1개를 사용해 절댓값을 구한다.          |
|     fac      | 입력된 숫자(피연산자) 1개를 사용해 팩토리얼 값을 구한다.     |
| sin cos, tan | 입력된 숫자(피연산자) 1개를 사용해 삼각함수 값을 구한다.     |
|     rad      | 입력된 숫자(피연산자) 1개를 사용해 라디안 값을 구한다.       |
|     root     | 입력된 숫자(피연산자) 2개를 사용해 제곱근 값을 구한다.       |



- **MainActivity 내부 메서드**

|  method  | function                                                     |
| :------: | :----------------------------------------------------------- |
|  Toggle  | 버튼 클릭 후 새로운 숫자(피연산자) 입력시 초기화한다.        |
| auto_Mul | 숫자(피연산자) 이후 log, 삼각함수 식, PI, exp가 등장시 자동으로 곱하기를 생성한다. |
| onClick  | 버튼이 눌렸을 때, 버튼의 id값에 따라서 수식을 입력 문자열(str)에 연산자, 피연산자, 괄호 소수점(0-9, Del, AC, +, -, *, /, ^, (, ), e, p 등)을 붙인다. 연결된 문자열이 화면에 출력하도록 한다. 'AC' 버튼을 클릭하면 입력한 수식이 모두 없어지도록 한다. 'Del' 버튼을 클릭하면 해당 수식에서 가장 마지막에 들어간 것이 지워진다. |



#### 4) 레이아웃

- activity_main.xml: 사용자가 보는 화면으로 출력되는 UI를 나타낸다. ScrollView 위젯, TextView 위젯, Button 위젯 등을 포함하고 있다.



---

### 3. 입출력 데이터 정의 (Data Structure Design)

- **데이터 종류**: 피연산자(double), 피연산자(String), 연산자(String), Button 위젯 기능(0-9, PI, e, 연산자(+, -, *, /, log, sin, cos, tan, pow, exp 등), AC, Del), 수식(문자열, String)

- **입력**: Button 위젯(피연산자, 연산자, AC, Del)
- **출력**: TextView 위젯(수식 계산한 결과값), historyView위젯(이전 계산 결과값), scrollView위젯(이전 계산 결과값이 쌓일 경우 출력)



----

### 4. 코딩 및 테스트 (Coding and Test)



- 애플리케이션 사칙연산

<img src = "https://github.com/sanga327/Java_Project/tree/main/images/사칙연산.gif" width="60%">



- 애플리케이션 log 연산

<img src = "https://github.com/sanga327/Java_Project/tree/main/images/log.gif" width="60%">



- 애플리케이션 root 연산

<img src = "https://github.com/sanga327/Java_Project/tree/main/images/root.gif" width="60%">



- 애플리케이션 mod 연산

<img src = "https://github.com/sanga327/Java_Project/tree/main/images/mod.gif" width="60%">



- 애플리케이션 PI

<img src = "https://github.com/sanga327/Java_Project/tree/main/images/pi.gif" width="60%">



- 애플리케이션 pow 연산

<img src = "https://github.com/sanga327/Java_Project/tree/main/images/^.gif" width="60%">



- 애플리케이션 cos 연산

<img src = "https://github.com/sanga327/Java_Project/tree/main/images/cos.gif" width="60%">



- 애플리케이션 fac 연산

<img src = "https://github.com/sanga327/Java_Project/tree/main/images/fac.gif" width="60%">



