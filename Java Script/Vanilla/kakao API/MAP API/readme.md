# KAKAO MAP API

작성일시: 2023년 10월 7일 오후 9:07
종류: SQL
복습: No

## 카카오 개발자 링크

[Kakao Developers](https://developers.kakao.com/)

# 지원하는 기능

- 각 API 및 기능의 Kakao SDK 지원 여부는 [지원 범위](https://developers.kakao.com/docs/latest/ko/getting-started/scope-of-support)에서 확인할 수 있습니다.

| API 및 기능 | 설명 | 문서 |
| --- | --- | --- |
| 주소 검색하기 | 특정 주소에 해당하는 장소 정보의 좌표를 검색합니다. | https://developers.kakao.com/docs/latest/ko/local/dev-guide#address-coord |
| 좌표로 행정구역정보 받기 | 좌표 값을 행정동, 법정동으로 변환합니다.맛집, 날씨 등 위치에 맞는 정보 제공 서비스에 활용할 수 있습니다. | https://developers.kakao.com/docs/latest/ko/local/dev-guide#coord-to-district |
| 좌표로 주소 변환하기 | 특정 좌표의 지번 주소 및 도로명 주소를 제공합니다. | https://developers.kakao.com/docs/latest/ko/local/dev-guide#coord-to-address |
| 좌표계 변환하기 | 특정 체계의 좌표 값을 다른 체계의 좌표 값으로 변환합니다.지원 좌표계: WGS84, WCONGNAMUL, CONGNAMUL, WTM, TM, KTM, UTM, BESSEL, WKTM, WUTM | https://developers.kakao.com/docs/latest/ko/local/dev-guide#trans-coord |
| 키워드 검색하기 | 키워드로 관련 장소 및 상세 정보를 검색합니다.각 장소 상세 페이지로 연결되는 URL을 제공합니다. | https://developers.kakao.com/docs/latest/ko/local/dev-guide#search-by-keyword |
| 카테고리 검색하기 | 카테고리로 관련 장소 및 상세 정보 검색합니다.각 장소 상세 페이지로 연결되는 URL을 제공합니다. | https://developers.kakao.com/docs/latest/ko/local/dev-guide#search-by-category |

**Kakao 지도 Javscript API** 는 키 발급을 받아야 사용할 수 있습니다.

그리고 키를 발급받기 위해서는 카카오 계정이 필요합니다.

키 발급에는 아래 과정이 필요합니다.

1. *[카카오 개발자사이트](https://developers.kakao.com/)* (https://developers.kakao.com) 접속

2. 개발자 등록 및 앱 생성

3. 웹 플랫폼 추가: 앱 선택 – [플랫폼] – [Web 플랫폼 등록] – 사이트 도메인 등록

4. 사이트 도메인 등록: [웹] 플랫폼을 선택하고, [사이트 도메인] 을 등록합니다. (예: http://localhost:8080)

5. 페이지 상단의 [JavaScript 키]를 지도 API의 appkey로 사용합니다.

6. 앱을 실행합니다.

- 등록한 도메인(예: http://localhost:8080)에서 웹 서버를 실행시켜 위 파일을 엽니다.

등록된 사이트 도메인에서만 지도API를 사용할 수 있기 때문에 반드시 등록해주세요.

왼쪽 메뉴의 열쇠모양 을 클릭하면 *[내 애플리케이션](https://developers.kakao.com/console/app)* 로 이동합니다. 아직 발급받은 키가 없다면 해당 페이지에 접속하여 키를 발급 받으세요.

## 시작하기

여러분은 간단한 코드를 통해 웹브라우저에 지도를 띄울 수 있습니다.

차근차근 한 단계씩 진행해 보도록 하겠습니다.

### 지도를 담을 영역 만들기

먼저 지도를 담기 위한 영역이 필요합니다. `500x400` 의 크기로 만들어 보겠습니다.

```jsx
<div id**=**"map" style**=**"width:500px;height:400px;"></div>
```

지도를 담을 영역으로 스타일이 지정된 `<div>` 태그를 선언합니다.

`<div>` 태그의 id값은 `map` 으로 하도록 하겠습니다.

### 실제 지도를 그리는 Javascript API를 불러오기

```jsx
<script type**=**"text/javascript" src**=**"//dapi.kakao.com/v2/maps/sdk.js?appkey=발급받은 APP KEY를 넣으시면 됩니다."></script>
```

`//` 이라는 상대 프로토콜을 사용하면, 사용자의 `http`, `https` 환경에 따라 자동으로 해당 프로토콜을 따라가게 됩니다.

API를 로딩하는 스크립트 태그는 HTML파일안의 `head`, `body` 등 어떠한 위치에 넣어도 상관없습니다.

하지만, 반드시 **실행 코드보다 먼저 선언되어야 합니다.**

### 지도를 띄우는 코드 작성

```jsx
**var** container **=** document.getElementById('map'); *//지도를 담을 영역의 DOM 레퍼런스***var** options **=** { *//지도를 생성할 때 필요한 기본 옵션*	center**:** **new** kakao.maps.LatLng(33.450701, 126.570667), *//지도의 중심좌표.*	level**:** 3 *//지도의 레벨(확대, 축소 정도)*};

**var** map **=** **new** kakao.maps.Map(container, options); *//지도 생성 및 객체 리턴*
```

*[Map](https://apis.map.kakao.com/web/documentation/#Map)* 객체의 두 번째 파라메터로 넣는 `options` 의 속성 중, `center` 는 **지도를 생성하는데 반드시 필요합니다.**

`center` 에 할당할 값은 *[LatLng](https://apis.map.kakao.com/web/documentation/#LatLng)* 클래스를 사용하여 생성합니다. 흔히 위경도 좌표라고 부르는 `WGS84` 좌표계의 좌표값을 넣어서 만드는데요, 생성인자는 `위도(latitude), 경도(longitude)` 순으로 넣어주세요.

전체 코드는 아래와 같습니다.

```jsx
**<!DOCTYPE html>**<html>
<head>
	<meta charset**=**"utf-8"/>
	<title>Kakao 지도 시작하기</title>
</head>
<body>
	<div id**=**"map" style**=**"width:500px;height:400px;"></div>
	<script type**=**"text/javascript" src**=**"//dapi.kakao.com/v2/maps/sdk.js?appkey=발급받은 APP KEY를 넣으시면 됩니다."></script>
	<script>
		**var** container **=** document.getElementById('map');
		**var** options **=** {
			center**:** **new** kakao.maps.LatLng(33.450701, 126.570667),
			level**:** 3
		};

		**var** map **=** **new** kakao.maps.Map(container, options);
	</script>
</body>
</html>
```

### 지도 라이브러리란?

**Kakao 지도 Javascript API** 는 지도와 함께 사용할 수 있는 `라이브러리` 를 지원하고 있습니다.

라이브러리는 javascript API와 관련되어 있지만 조금 특화된 기능을 묶어둔 것을 말합니다. 이 기능은 추가로 불러와서 사용할 수 있도록 되어있습니다.

현재 사용할 수 있는 라이브러리는 다음과 같습니다.

- `clusterer`: 마커를 클러스터링 할 수 있는 *[클러스터러](https://apis.map.kakao.com/web/documentation/#MarkerClusterer)* 라이브러리 입니다.
- `services`: *[장소 검색](https://apis.map.kakao.com/web/documentation/#services_Places)* 과 *[주소-좌표 변환](https://apis.map.kakao.com/web/documentation/#services_Geocoder)* 을 할 수 있는 *[services](https://apis.map.kakao.com/web/documentation/#services)* 라이브러리 입니다.
- `drawing`: 지도 위에 마커와 그래픽스 객체를 쉽게 그릴 수 있게 그리기 모드를 지원하는 *[drawing](https://apis.map.kakao.com/web/documentation/#drawing)* 라이브러리 입니다.

라이브러리는 계속해서 추가될 예정입니다.

### 라이브러리 불러오기

라이브러리는 추가로 불러서 사용해야 합니다. 아래와 같이 파라메터에 추가하여 로드합니다.

```jsx
<script type**=**"text/javascript" src**=**"//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=LIBRARY"></script>
```

`LIBRARY` 토큰 부분에 사용하고자하는 라이브러리 이름을 적으면 해당 라이브러리를 불러올 수 있습니다.

```jsx
*`<!-- services 라이브러리 불러오기 -->*<script type**=**"text/javascript" src**=**"//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services"></script>`

*`<!-- services와 clusterer, drawing 라이브러리 불러오기 -->*<script type**=**"text/javascript" src**=**"//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services,clusterer,drawing"></script>`
```