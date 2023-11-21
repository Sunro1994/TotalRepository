<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../allUsedHeader.jsp"%>

<div class="adminPwCheck">
        <p><input id="adminCheck" type="password" name="travelMaker_Member_UserPw" placeholder="비밀번호를 입력해주세요"></p>
        <p><input id="adminCheckSubmit" type="submit" value="확인"></p>
</div>

<script>
    const inputPw = document.getElementById('adminCheck')
    const checkAdmin = document.getElementById('adminCheckSubmit')

    checkAdmin.addEventListener("click", ()=> {
        // 비동기로 비밀번호와 salt 값을 가져와야함
        $.ajax({
            type: 'POST',
            url: '${cpath}/ajax/adminCheck',
            data: { password: inputPw.value },
            success: function (resp) {
                if (resp == '${user.travelMaker_Member_UserPw}') {
                    // 비밀번호가 일치할 때 페이지 이동
                    location.href = '${cpath}/Admin/admin';
                } else {
                    alert('비밀번호가 일치하지 않습니다.');
                }
            }
        })
    })
</script>

</body>
</html>