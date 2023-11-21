<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../allUsedHeader.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link rel="stylesheet" href="${cpath}/css/main_css/recommend_travel_view.css" type="text/css">`
<!-- jQuery -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- SweetAlert2 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js"></script>
   

<div class="container">
    <div class="title">
        <div class="title_container">
            <div class="title_Wrap">
                <h2>
                    <em>${dto.recommend_travel_title}</em>
                </h2>
            </div>
            <div class="title_addr">
                <span>${dto.recommend_travel_address}</span>
            </div>


        </div>
    </div>

    <div class="content">
        <div class="content_img">
            <img src="${dto.recommend_travel_img}"/>
        </div>

       <!-- 강릉 단오제 -->
        <c:if test="${dto.recommend_travel_idx == 13}">
            <div class="content_subimg">
                <ul>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fb9Gzg2%2FbtszK7YseNC%2FzvKJwnRks0V7SEjSKut2W0%2Fimg.jpg"></li>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FFzx6A%2FbtszI0lGHL4%2Fg4zvdkxfw0JBl8ks8zRjwK%2Fimg.jpg"></li>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F0o8gW%2FbtszMdqcXTb%2Fe1ctcZ7GkHjeSmN6JVZkq1%2Fimg.jpg"></li>
                </ul>
            </div>
        </c:if>

        <!-- 거제 바다로세계로 -->
        <c:if test="${dto.recommend_travel_idx == 33}">
            <div class="content_subimg">
                <ul>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FPTEL9%2FbtszKbmB8hn%2FAykQlprwvaZgp35KNSwwc1%2Fimg.jpg"></li>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FOTb0i%2FbtszLtNzXj1%2F1awzRqPmvuUL9M8i1htGw0%2Fimg.jpg"></li>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F3mqSt%2FbtszHE4b1qD%2Fd6toZAnP0llakanqeOIgNK%2Fimg.jpg"></li>
                </ul>
            </div>
        </c:if>

        <!-- 고성 공룡 엑스포 -->
        <c:if test="${dto.recommend_travel_idx == 49}">
            <div class="content_subimg">
                <ul>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FumknT%2FbtszLYtbn14%2F3G7N8QGom67JuYYlwmE1j1%2Fimg.jpg"></li>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FmxysZ%2FbtszQCQxj0M%2F3KDIz9GStknk12JS5bdUN1%2Fimg.jpg"></li>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FHxaTb%2FbtszKFubEvp%2FMIlmys8xGpZRzw7TK5xK7k%2Fimg.jpg"></li>
                </ul>
            </div>
        </c:if>

        <!-- 고창 핑크 뮬리 -->
        <c:if test="${dto.recommend_travel_idx == 76}">
            <div class="content_subimg">
                <ul>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fc2Ak81%2FbtszHGVdWmq%2FfTtAYPN8IH0WP4zyPsaQNK%2Fimg.jpg"></li>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FsnsJs%2FbtszM0RPyoU%2FOx4HqmpNvvaPakD6ZtddY0%2Fimg.jpg"></li>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FMLxk5%2FbtszM0K30Kq%2F41w9wxrNHb7IrEsdFxJ2r0%2Fimg.jpg"></li>
                </ul>
            </div>
        </c:if>

        <!-- 거창 감악산 꽃&별 여행 -->
        <c:if test="${dto.recommend_travel_idx == 5}">
            <div class="content_subimg">
                <ul>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FPc32s%2FbtszOLmyUE4%2FZkblyodsjrbTHN4SQi3no1%2Fimg.jpg"></li>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcwlN08%2FbtszKJKhE40%2FKNhUEPcosXfMmcKgC8i29k%2Fimg.jpg"></li>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FrW3Hr%2FbtszLla44xP%2FLElaXqm4w1UIthBWZgkyCk%2Fimg.jpg"></li>
                </ul>
            </div>
        </c:if>

        <!-- 강진 춤추는 갈대 -->
        <c:if test="${dto.recommend_travel_idx == 28}">
            <div class="content_subimg">
                <ul>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FEZ5Av%2FbtszKznDFgx%2FkNU9QCoVlORo1oOJle5wV0%2Fimg.jpg"></li>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcogNEm%2FbtszOLUn7lw%2FfVUbEkH6uHBfdk7y2ywh91%2Fimg.jpg"></li>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FdxBfcX%2FbtszKIdu7If%2FiW22L1HWWP2PSn58RXz0Ek%2Fimg.jpg"></li>
                </ul>
            </div>
        </c:if>

        <!-- 공주 공산성 미디어아트 -->
        <c:if test="${dto.recommend_travel_idx == 86}">
            <div class="content_subimg">
                <ul>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FsaWYR%2FbtszL0xIOyB%2Fgplyx6nGjful6pF2DlGZK0%2Fimg.jpg"></li>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbGLKb5%2FbtszK4UQfeJ%2FGgFNeejrXMAQkMkND5Iaz1%2Fimg.jpg"></li>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcnEwZm%2FbtszK7jPSta%2F5L8kLaFQYn1uF4TZpMU9Z1%2Fimg.jpg"></li>
                </ul>
            </div>
        </c:if>

        <!-- 기장 멸치축제-->
        <c:if test="${dto.recommend_travel_idx == 98 }">
            <div class="content_subimg">
                <ul>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbyyeh3%2FbtszVr9ig2j%2FvK2MEtFeZZ8YHnC0QIwJk0%2Fimg.jpg"></li>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F5yfF2%2FbtszUqC4p6X%2FVViuFkH1lAQ7IKKicfViS1%2Fimg.jpg"></li>
                    <li><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbqAq5n%2FbtszSJv9Jvo%2FFZMALzQ1ZIfOjOh5TOrHq1%2Fimg.jpg"></li>
                </ul>
            </div>
        </c:if>

        <div class="detail">
            <br>
            <h3>상세정보</h3>
        </div>

        <div class="detail_content">
            <br>
            <p>${dto.recommend_travel_content}</p>
        </div>

        <br>
        <br>

        <div class="detail">
            <h3>정보</h3>
            <br>
            <div class="detailInfo">
                <p><img src="https://cdn.visitkorea.or.kr/kfes/resources/img/valentine_day.png"> ${dto.recommend_travel_eventstartdate}  ~ ${dto.recommend_travel_eventenddate}</p>
                <p><img src="https://cdn.visitkorea.or.kr/kfes/resources/img/location_ico.png"> ${dto.recommend_travel_address}</p>
                <p><img src="https://cdn.visitkorea.or.kr/kfes/resources/img/call_ico.png"> ${dto.recommend_travel_tel}</p>
<%--                <p>${dto.recommend_travel_eventstartdate}  ~ ${dto.recommend_travel_eventenddate}</p>--%>
<%--                <p> ${dto.recommend_travel_address}</p>--%>
<%--                <p>${dto.recommend_travel_tel}</p>--%>
            </div>
        </div>

        <br>
        <br>

        <div class="detail">
        <h3>길찾기</h3>
        </div>
        <div class="map">
            <div id="map"></div>
            <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9a9243386f258c5d107f2416e0bf8f4e"></script>
            <script>
                var mapContainer = document.getElementById('map');
                var mapOptions = {
                    center: new kakao.maps.LatLng(${dto.recommend_travel_mapy}, ${dto.recommend_travel_mapx}),
                    level: 3  };
                //지도 확대 레벨

                var map = new kakao.maps.Map(mapContainer, mapOptions);
                //마커가 표시될 위치
                var markerPosition = new kakao.maps.LatLng(${dto.recommend_travel_mapy}, ${dto.recommend_travel_mapx});
                // 마커 생성
                var marker = new kakao.maps.Marker({
                    position: markerPosition
                });

                // 마커가 지도 위에 표시되게 설정
                marker.setMap(map);

                // 마커를 지도 위에서 제거하는 코드
                // marker.setMap(null);
            </script>
        </div>
        </div>
            <c:if test="${user.travelMaker_Member_IsAdmin == 'Y'}">
                <div class="btns">
                    <button id="modifyBtn">수정하기</button>
                    <button id="deleteBtn">삭제하기</button>
                </div>
            </c:if>
    </div>

</div>

<script>
    const deleteBtn = document.getElementById('deleteBtn')
    const modifyBtn = document.getElementById('modifyBtn')
    deleteBtn.onclick = () => {
        swal({
            title : '정말로 삭제하시겠습니까 ?',
            text : '삭제 하시면 복구 할 수 없습니다',
            type : 'warning',

            showCancelButton: true,                 // cancel버튼 보이기. 기본은 원래 없음
            confirmButtonColor: '#3085d6',      // confrim 버튼 색깔 지정
            cancelButtonColor: '#d33',              // cancel 버튼 색깔 지정
            confirmButtonText: '승인',                // confirm 버튼 텍스트 지정
            cancelButtonText: '취소',                  // cancel 버튼 텍스트 지정
        }).then(result => {
            // 만약 result 가 isConfirm 이면,
            if(result.value){
                swal('완료', '해당 게시글이 삭제되었습니다', 'success')


                let idx = ${dto.recommend_travel_idx}
                    // 삭제 알림이 뜬 후 1초 후 삭제 링크로 이동
                    setTimeout(function() {
                        location.href = '${cpath}/Admin/recommendDelete/' + ${idx};
                    }, 1000)
            }
            else {
                swal ('취소', '취소 하셧습니다', 'error')
            }
        })
    }

    modifyBtn.onclick = () => {
        const idx = ${dto.recommend_travel_idx}
        location.href = '${cpath}/Admin/recommendModify/' + idx
    }
</script>



</body>
</html>