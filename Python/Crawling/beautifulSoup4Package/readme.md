# 05.beautifulSoup 패키지

작성일시: 2023년 10월 2일 오전 12:15
종류: SQL
복습: No

# BeautifulSoup란?

HTML 및 XML 파일의 내용을 읽을 때 다음 파서 이용

✅html.parser , lxml, lxml-xml, html5lib

파이썬이 내장하고 있는 파서 사용 가능

## HTML파싱

1. BeautifulSoup의 메인 패키지인 bs패키지에서 BeautifulSoup()함수 임포트
2. 파싱할 HTML 문서와 파싱에 사용될 파서(구문 분석기)를 지정하여 호출
3. HTML문서에 대한 파싱이 끝나면 트리 구조 형식으로 DOM 객체 생성
4. **`BeautifulSoup(파싱할 html, 사용할 파서타입)`**

![Untitled](https://github.com/Sunro1994/JavaScript/assets/132982907/0cc7bce0-5f3f-43b1-bfec-721540a01ccd)

## 파서 라이브러리 비교

![Untitled 1](https://github.com/Sunro1994/JavaScript/assets/132982907/830c3f23-bdde-42a9-8168-f0a2c6f0087e)
![Untitled 2](https://github.com/Sunro1994/JavaScript/assets/132982907/650d983d-824d-4c98-af7c-f094389bb0b8)

## bs4.BequtifulSoup 객체 태그 접근 방법

<html>,<head>태그와 <body>태그는 제외하고 접근하려는 태그에 계층 구조를 적용한다.

태그명을 . 연산자와 함께 적용

![Untitled 3](https://github.com/Sunro1994/JavaScript/assets/132982907/7c01aa92-996f-414a-a8e1-83cc51e83baf)

## 태그의 정보 추출

✅태그명 추출 ⇒ bs.태그명.name

✅속성 추출 ⇒ bs.태그명[’속성명’] , bs.태그명.attrs

## 태그의 콘텐츠 추출

✅ bs.태그명.string/text/contents/strings/get_text()

✅bs.태그명.string.strip()/text.strip()/stripped_strings/get_text(strip=True) 공백을 제거하는 메서드

## 태그로부터 다른 태그 이동

✅ bs.태그명.parent(부모태그)/children(자식태그)

[✅bs.태그명.next/previous_sibling](http://✅bs.태그명.next/previous_sibling) 또는 [bs.태그명.next/previous_siblings](http://bs.태그명.next/previous_siblings) 를 통해 형제 태그 추출

✅bs.태그명.descendants를 통해 자손 태그들을 추출한다.

![Untitled 4](https://github.com/Sunro1994/JavaScript/assets/132982907/24b489e4-bf06-47e0-ac5e-e2b6bc7cb25e)

## bs4.BeautifulSoup 객체의 주요 메서드

HTML문서에 대한 파싱이 끝나고 생성된 트리 구조 형식의 DOM 객체

⇒ bs4.BeautifulSoup 객체의 속성으로 접근 가능

태그 찾기의 주요 메서드 : find_all() , find() ,select()

✅ bs.find_all()

주어진 기준에 맞는 모든 태그들을 찾아온다.

결과값은 bs4.element.ResultSet

find_all( [name=None, attrs={}, recursive = True, text=None, limit = None, ** kwargs)

![Untitled 5](https://github.com/Sunro1994/JavaScript/assets/132982907/5dd2eddd-76a9-43e0-8c26-5dd692f45af7)
![Untitled 6](https://github.com/Sunro1994/JavaScript/assets/132982907/dc3c6f01-8ff7-44a7-befc-26aca3863612)

✅bs.find()는 find_all()에서  limit=1을 지정한것과 동일하게 수행

find_all의 argument값을 동일하게 사용 가능

결과값 ⇒ bs4.element.Tag객체로 리턴

결과값이 없으면 None을 리턴

✅ 주어진 CSS선택자에 맞는 모든 태그를 찾아온다.

결과는 list객체로 리턴

![Untitled 7](https://github.com/Sunro1994/JavaScript/assets/132982907/b135192f-b203-4380-b79b-97a51e9de3fb)
![Untitled 8](https://github.com/Sunro1994/JavaScript/assets/132982907/7f1ac67d-a88c-4d3b-9b97-560f1f62c210)