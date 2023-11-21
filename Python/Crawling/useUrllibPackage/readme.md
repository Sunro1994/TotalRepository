# 03. urllib패키지

작성일시: 2023년 10월 1일 오전 1:10
종류: SQL
복습: No

# urllib 패키지

URL작업을 위한 여러 모듈을 모은 패키지

파이썬의 표준 라이브러리

## 주요모듈

✅urllib.request = url문자열을 가지고 요청 기능 제공

✅urllib.response = urllib모듈에 의해 사용되는 응답 클래스들 제공

✅urllib.parse = url문자열을 파싱하여 해석하는 기능 제공

✅urllib.error =  urllib.request에 의해 발생하는 예외 클래스들 제공

✅urllib.robotparser = robots.txt파일을 구문 분석하는 기능 제공

## urllib.request모듈

url문자열을 가지고 http요청을 수행

urlopen()함수를 사용하여 웹 서버에 페이지를 요청하고, 서버로부터 받은 응답을 저장하여 응답객체(http.client.HTTPResponse)를 반환

![Untitled](https://github.com/Sunro1994/Python/assets/132982907/7a804dd8-e1fd-4494-bdbc-383230978acd)

## http.client.HTTPResponse클래스

웹 서버로부터 받은 응답을 래핑하는 객체

응답 헤더나 응답 바디의 내용을 추출하는 메서드 제공

HTTPResponse.read([amt]) : 응답바디의 내용 추출, 응답 내용을 바이트열로 읽어온다. 영어는 잘 읽어오지만 한글은 16진수로 읽어오기때문에 **`res.read().decode(’utf-8’)`**이라는 문자셋이 필요하다.

HTTPResponse.getheaders() : 응답헤더의 내용 추출

### 웹 페이지 인코딩 체크

❗웹 크롤링 하려는 웹 페이지가 어떤 문자셋으로 작성되었는지 파악하는 것이 필수

❗페이지의 문자셋 정보 : 페이지의 소스 내용에서 <meta>태그의 charset정보를 체크하면 파악 가능

![Untitled 1](https://github.com/Sunro1994/Python/assets/132982907/c2816c8d-8f31-4c37-8cd7-17d60b2dab49)

❗파이썬에서 제공되는 http.client.HTTPMessage객체의 get_content_charset()메서드로도 확인이 가능하다.

get_content_charset()메서드를 호출하기 전에 urlopen()함수의 리턴 값인 HTTPResponse객체의 **`info()`**메서드를 호출하면 HTTPMessage객체가 리턴 된다. 해당 리턴값에 **`get_content_charset()`**메서드를 호출하면 문자 셋 정보를 문자열로 리턴받는다.

![Untitled 2](https://github.com/Sunro1994/Python/assets/132982907/962ad3f8-31cc-4c2f-9fda-ee1960a8bdde)

## urllib.parse모듈

웹 서버에 페이지 또는 정보를 요청할 떄 함께 전달하는 데이터

Get방식요청 : Query문자열

POST방식요청: 요청 파라미터

❗영문과 숫자는 그대로 전달되지만 한글은 %기호와함꼐 16진수 코드 값으로 전달되어야 한다.

urllib.parse.urlencode()를 사용할 수 있다.

### urlparse(”URL문자열”)

argument에 지정된 URL문자열의 정보를 파싱하고 각각의 정보를 정해진 속성으로 저장하여 ParseResult객체를 리턴

각 송성들을 이용하여 필요한 정보만 추출할 수 있다.

![Untitled 3](https://github.com/Sunro1994/Python/assets/132982907/02c75ef5-3f44-40c6-a527-490a5faf33c9)

### urlencode()

메서드의 argument로 지정된 name과 value로 구성된 딕셔너리 정보를 정해진 규격의 Query문자열 또는 요청 파라미터 문자열로 리턴

한글또한 %와함께 16진수로 변환해준다.

![Untitled 4](https://github.com/Sunro1994/Python/assets/132982907/f49a5688-1c24-4cd7-8762-48e429fad840)

## POST방식으로 파라미터를 포함하여 요청하기(1)

GET방식과 동일하기 name과value로 구성되는 문자열 생성

POST방식요청에서는 바이트 형식의 문자열로 전달해야 하므로 encode(’ascii’)메서드를 호출하여 바이트 형식의 문자열로 변경한다.

urllib.requesturlopen()호출시 바이트 형식의 문자여롤 변경된 데이터를 두 번째 argument로 지정

![Untitled 5](https://github.com/Sunro1994/Python/assets/132982907/75ed19b7-383d-4cc5-b869-2c435d680ab1)

## POST방식으로 파라미터를 포함하여 요청

url문자열과 요청 파라미터 문자열을 지정한 urllib.request.Request객체 생성

urllib.request.rulopen()함수 호출 시 URL문자열 대신 urllib.request.Request객체 지정

![Untitled 6](https://github.com/Sunro1994/Python/assets/132982907/bcbc38f2-8aae-426a-a255-b5362cdb2a1b)

## 실습코드

✅urllib.request.urlopen(url)을 통해 해당 url의 정보를 가져와 f 객체에 담는다.(f의 타입은 response)

✅encoding이라는 객체에 가져온 f의 info()메서드의 content_chraset()메서드를 호출한 결과를 담는다. >> 인코딩 타입을 알 수 있다.

✅f.read(500).decode(encoding)<< f객체를 500바이트만큼 읽고 인코딩 타입을 지정해준다.

```python
# print("===================================")
# url='https://www.python.org/'
# f = urllib.request.urlopen(url)
# print(type(f))
# print(type(f.info()))
# encoding = f.info().get_content_charset()
# print(url, '페이지의 인코딩 정보 :',encoding)
# text=  f.read(500).decode(encoding)
# print(text)
# print("===================================")
# url='https://www.daum.net/'
# f = urllib.request.urlopen(url)
# encoding = f.info().get_content_charset()
# print(url,'페이지의 인코딩 정보 : ', encoding)
# text = f.read(500).decode(encoding)
# print(text)
# print("===================================")
url='https://www.aladin.co.kr/home/welcome.aspx'
f = urllib.request.urlopen(url)
encoding = f.info().get_content_charset()
print(url,'페이지의 인코딩 정보 : ', encoding)
text = f.read(500).decode(encoding)
print(text)
print("===================================")
```

✅res에 urlopen을 통해 요청한 결과를 담는다.

✅read().decode(’utf-8’)을 통해 res의 결과를 읽고 utf-8로 디코딩한 결과를 볼 수 있다.

```python
import urllib.request

res = urllib.request.urlopen("http://unico2013.dothome.co.kr/crawling/tagstyle.html")
print(res)
print("[header정보]-------")
res_header=res.getheaders()
for s in res_header:
    print(s)
print("[body 내용]------------")
# utf-8로 변환하지 않으면 16진수 코드를 반환한다.
# print(res.read())
print(res.read().decode('utf-8'))
```