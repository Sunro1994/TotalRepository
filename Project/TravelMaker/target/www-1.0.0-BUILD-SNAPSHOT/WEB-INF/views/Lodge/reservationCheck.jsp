<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../allUsedHeader.jsp" %>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js"></script>


    <div style="display: flex; flex-direction: column; justify-content: center; align-items: center; padding-top: 6%;">
        <div><img src="${cpath }/img/tm330.png"></div>
        <h1>예약 해주셔서 감사합니다</h1>
        <h2>즐거운 여행되시기 바랍니다</h2>
        <span>(자세한 예약내용은 상단 보관함 > 예약내역에서 확인가능합니다)</span>
    </div>

</body>

<script>
        swal('결제가 완료되었습니다.',"10초 후에 이동합니다.",'success');
    setTimeout(function () {
        window.location.href = "${cpath}";
    }, 10000); // 5000 밀리초 (5초)
</script>
</html>