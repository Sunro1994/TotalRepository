# 디자인 Model1 과 Model2의 차이

작성일시: 2023년 8월 31일 오후 11:24
복습: No

## 🟰 Model 1

![https://blog.kakaocdn.net/dn/kVVWN/btruiSlmAvu/eTXJQB337qmWf8cBGFGHXK/img.gif](https://blog.kakaocdn.net/dn/kVVWN/btruiSlmAvu/eTXJQB337qmWf8cBGFGHXK/img.gif)

✅JSP 파일 내에서 뷰와 컨트롤러 모두 실행된다.

✅JSP페이지에서 로직을 처리하기 위해 코드와 출력을 담당하는 코드가 함께 존재

✅웹브라우저의 요청과 요청에 대한 작업을 처리함과 동시에 클라이언트에게 결과를 출력

- [ ]  장점
    
    📌단순한 구조로 개발 기간이 짧다.
    
    📌난이도가 낮다.
    
- [ ]  단점
    
    📌복잡도가 노아질수록 기능이 섞인 코드 때문에 유지보수가 어렵다.
    
    📌디자이너와 개발자 간 의사소통이 필요
    

## 🟰Model2

![https://blog.kakaocdn.net/dn/cpb4CU/btruiR08Sl4/zRjs2p6R53izpttS0pQEOK/img.gif](https://blog.kakaocdn.net/dn/cpb4CU/btruiR08Sl4/zRjs2p6R53izpttS0pQEOK/img.gif)

✅ 웹 개발에 MVC패턴을 적용해 model1에 비해 더욱 편리하게 유지 보수 할 수 있다.

✅ 웹 브라우저의 요청을 컨트롤러(Servlet)이 받고, 모델에서 요청에 대한 결과를 도출

✅ 다시 컨트롤러가 사용자에게 보여줄 알맞은 뷰를 선택하고 데이터를 전달

✅ 뷰는 사용자에게 화면을 출력

✅ Model은 JavaBean / View는 JSP / Controller는 Servlet이 담당한다.(대부분)

- [ ]  장점
    
    컨트롤러와 뷰의 분리로 유지보수및 확장이 편하다
    
    디자이너와 개발자의 작업이 분리되어 분업에 용이하다.
    
- [ ]  단점
    
    개발 초기 단계에 구조 설계에 비교적 많은 작업량과 시간이 필요
    
    자바와 구조에 대한 깊은 이해도가 필요