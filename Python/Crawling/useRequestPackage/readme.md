# 04.request패키지

작성일시: 2023년 10월 1일 오전 1:56
종류: SQL
복습: No

## request패키지

HTTP 프로토콜과 관련된 기능 지원

pip install request를 통해 설치 가능

## urllib패키지와 request 패키지 비교

![Untitled](https://github.com/Sunro1994/Python/assets/132982907/df48a970-9e30-47c2-aedb-8776de8b6aab)

## requests.request()

requests 패키지의 대표 함수

HTTP 요청을 서버에 보내고 응답을 받아오는 기능 지원

![Untitled 1](https://github.com/Sunro1994/Python/assets/132982907/64be2d9c-6a6c-4b2d-ae4d-fc85c4b447c3)

![Untitled 2](https://github.com/Sunro1994/Python/assets/132982907/5b46ab74-0fa0-4227-a5c2-7f3686a52647)

## HTTP 요청 방식을 지원하는 함수

GET 방식 : 요청판 페이지의 헤더, 바디를 모두 받아오는 요청
                 Query 문자열을 추가하여 요청 가능

HEAD방식 : 콘텐츠 요청 없이 헤더만 받아오는 방식, 요청 바디에 요청 파라미터 데이터를 추가하여 요청, 헤더와 바디를 모두 받아 옴

### GET방식 요청

**requests.request(’GET’,url,params)**

**requests.get(url,params)**

Query문자열을 포함하여 요청시 params매개변수에 딕셔너리,튜플리스트,바이트열 형식으로 전달하며, Query문자열이 없을경우 params매개변수의 설정을 생략한다.

### POST방식 요청

**requests.request(’POST’,url,data/json등)**

**requests.get(url,data/json등)**

data : (선택적) 요청 시 바디에 담아서 전달할 요청 파라미터를 지정 딕셔너리, 튜플리스트, 바이트열 형식

json : (선택적) 요청 시 바디에 담아서 전달할 JSON타입의 객체를 지정

## 응답처리

requests패키지의 request(),get(),head(),post() 모두 리턴 값은 requests.models.Response객체이다.

### Text

문자열 형식으로 응답 콘텐츠 추출

추출 시 사용되는 문자 셋은 ‘ISO-8859-1’이므로 ‘utf-8’이나 ‘euc-kr’문자 셋으로 작성된 콘테츠 추출 시 한글이 깨지는 현상 발생

추출 전 응답되는 콘텐츠의 문자 셋 정보를 파악하여 Response객체의 encoding속성에 문자 셋 정보를 설정한 후 추출

### Content

바이트열 형식으로 응답 콘텐츠 추출

응답 콘텐츠가 이미지와 같은 바이너리 형식인 경우 사용

한글이 들어간 문자열 형식인 경우 r.content.decode(’utf-8’)를 사용해서 디코드 해야 한다.