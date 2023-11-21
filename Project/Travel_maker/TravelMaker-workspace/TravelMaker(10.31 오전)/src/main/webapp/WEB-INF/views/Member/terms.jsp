
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>TravelMaker 이용약관</title>
    <style>
        .logo {
            display: flex;
            margin: 0 auto;
        }
        .logo img {
            width: 120px;
            height: 120px;
            margin-left: 0;
        }
        .logo > h3 {
            text-align: center;
            margin-top: 50px;
            font-weight: 900;
        }
        .innerBox {

            width: 500px;
            margin: 0 auto;
        }
        .content {
            margin: 10px auto;
            padding-left: 30px;
        }
        .necessary {
            font-style: normal;
            color: red;
        }
        em {
            font-style: normal;
        }
        .inLabelBox {
            position: relative;
            width: 400px;
            height: 80px;
            margin: 10px auto;
            border: 2px solid darkgrey;
            overflow-y: scroll;
        }
        .inLabelBoxStrong {
            font-weight: 900;
        }
        .inLabelBoxText {
            margin-top: 5px;
        }
        .btn{
            width: 400px;
            height: 50px;
            display: none;
            margin-left: 30px;
        }

    </style>
</head>
<body>
<div class="container">
    <div class="innerBox">
        <div class="logo">
            <a href="${cpath}"><img src="${cpath}/img/tm400.png"></a>
            <h3>TravelMaker 이용약관</h3>
        </div>
        <div class="content">
            <p class="All_check">
                <label>
                    <input type="checkbox" id="checkAll" class="inputCheckBtn">
                    <strong>전체 동의</strong>
                </label>
            </p>
            <p>
                <label>
                    <input type="checkbox" id="checkBtnNecessary" class="inputCheckBtn" value="checked">
                    이용약관 동의 <em class="necessary">[필수]</em>
                    <div class="inLabelBox">
                        <h6 class="inLabelBoxStrong">
                            제1조 (목적)
                            본 약관은 TravelMaker(이하 "회사"라 함)이 운영하는 여행 서비스(이하 "서비스"라 함)의 이용조건 및 절차, 이용자와 회사의 권리, 의무, 책임사항 등을 규정함을 목적으로 합니다.
                        </h6>
                        <p class="inLabelBoxText">
                            제2조 (약관의 효력 및 변경)
                            1. 본 약관은 서비스를 이용하고자 하는 모든 이용자에게 적용됩니다.
                            2. 회사는 필요한 경우 약관을 변경할 수 있으며, 변경된 약관은 서비스에 공지함으로써 효력을 발생합니다. 이용자는 변경된 약관에 동의하지 않을 경우 서비스 이용을 중단할 수 있습니다.
                        </p>
                        <p class="inLabelBoxText">
                            제3조 (회원가입)
                            1. 이용자는 회사가 제공하는 회원가입 양식에 따라 필요한 정보를 제공하여 회원가입을 완료해야 합니다.
                            2. 회사는 이용자의 회원가입을 승인한 후, 해당 이용자에게 서비스 이용을 허가합니다.
                        </p>
                        <p class="inLabelBoxText">
                            제4조 (서비스 이용)
                            1. 이용자는 회사가 제공하는 서비스를 이용할 수 있습니다.
                            2. 서비스 이용 시 이용자는 관련 법령, 약관, 이용안내 등 회사가 통지한 사항을 준수해야 합니다.
                            3. 이용자는 회사의 서비스 이용규칙을 준수해야 하며, 타인의 권리를 침해하지 않아야 합니다.
                            4. 회사는 서비스의 원활한 제공을 위해 필요한 경우 일부 서비스의 이용을 제한할 수 있습니다.
                        </p>
                        <p class="inLabelBoxText">
                            제5조 (정보의 보호)
                            1. 회사는 이용자의 개인정보를 보호하기 위해 최선의 노력을 다합니다. 개인정보의 수집, 보관, 이용, 제공 등은 관련 법령과 회사의 개인정보 처리 방침에 따릅니다.
                            2. 이용자는 개인정보의 정확성 및 안전을 위해 개인정보를 최신화하고 외부에 노출되지 않도록 주의해야 합니다.
                        </p>
                        <p class="inLabelBoxText">
                            제6조 (책임과 면책)
                            1. 이용자는 본인의 책임 하에 서비스를 이용해야 합니다. 회사는 이용자의 부적절한 이용으로 인해 발생한 손해에 대해 어떠한 책임도 지지 않습니다.
                            2. 회사는 천재지변, 전쟁, 기간통신사업자의 서비스 중지 등 불가항력적인 사유로 인해 서비스 제공에 장애가 발생한 경우 책임을 지지 않습니다.

                        </p>
                        <p class="inLabelBoxText">
                            제7조 (분쟁의 해결)
                            1. 본 약관에 관한 분쟁은 대한민국의 관할법원에 제소합니다.
                            2. 회사와 이용자 간의 분쟁은 원만한 해결을 위해 성실히 협의하여 해결하려고 노력해야 합니다.
                        </p>
                        <p class="inLabelBoxText">
                            제8조 (기타)
                            본 약관에 명시되지 않은 사항은 관련 법령 및 회사의 운영정책에 따릅니다.
                        </p>
                    </div>
                </label>
            </p>
            <p>
                <label>
                    <input type="checkbox" id="checkAllNecessary" class="inputCheckBtn" value="checked">
                    만 14세 이상 확인 <em class="necessary">[필수]</em>
                    <div class="inLabelBox">
                        <h6 class="inLabelBoxStrong">TravelMaker 는 만 14세 미만 아동의 서비스 이용을 제한하고 있습니다.</h6>
                        <p class="inLabelBoxText">정보통신망 이용촉진 및 정보보호 등에 관한 법률에는 만 14세미만 아동의 개인정보 수집 시 법정대리인 동의를 받도록 규정하고 있으며, 만 14세 미만 아동이 법정대리인 동의없이 회원가입을 하는 경우 회원탈퇴 또는 서비스 이용이 제한될 수 있음을 알려드립니다.</p>
                    </div>
                </label>
            </p>
            <p>
                <label>
                    <input type="checkbox" id="checkAllNecessary" class="inputCheckBtn" value="checked">
                    개인정보 수집 및 이용 동의 <em class="necessary">[필수]</em>
                    <div class="inLabelBox">
                        <p class="inLabelBoxText">수집 및 이용 목적 <br>
                            회원가입, 서비스 이용, 상담 및 부정이용 기록 확인, 서비스 이용 가능 연령 확인 및 본인 여부 확인, 이용자의 상품 및 서비스 이용 실적 정보를 활용한 통계 분석 및 상품 서비스 개선 제공, 맞춤형 서비스 제공을 위한 이용자 식별
                        </p>
                        <p class="inLabelBoxText">
                            수집 항목<br>
                            [일반 회원]
                            휴대전화번호, 이메일, 기기고유번호(UUID, SSAID), 닉네임, 성별, 생년월일, 비밀번호(이메일로 가입 시), SNS 계정 정보(페이스북, 카카오, 네이버, 애플, 구글 계정으로 가입 시)

                            [비즈니스 회원]
                            휴대전화번호, 이메일, 기기고유번호(UUID, SSAID), 닉네임, 비밀번호, 회사명, 회사 이메일, 이름, 성별, 생년월일

                            [서비스 이용 및 부정이용 기록 확인]
                            서비스 이용시간/이용기록, 접속로그, 이용컨텐츠, 접속IP정보, 기기모델명, 브라우저 정보

                            [본인 인증 시]
                            CI(연계정보)/DI(중복가입확인정보)
                        </p>
                        <h6 class="inLabelBoxStrong">
                            회원 탈퇴 시 또는 계약 만료 시까지
                            - 내부 방침에 따라 보존할 필요가 있는 경우 고지 기간까지 보유
                            - 관계 법령에 따라 보존할 필요가 있는 경우 해당 법령에서 요구하는 기한까지 보유
                        </h6>
                    </div>
                </label>
            </p>
            <p>
                <label>
                    <input type="checkbox" id="checkBtn" class="inputCheckBtn">
                    개인정보 수집 및 이용 동의 <em>[선택]</em>
                    <div class="inLabelBox">
                        <p class="inLabelBoxText">수집 및 이용 목적 <br>
                            서비스 이용, 상담 및 부정 거래 기록 확인
                        </p>
                        <p class="inLabelBoxText">
                            수집 항목<br>
                            [내 정보 관리]
                            -이름, 프로필 사진
                        </p>
                        <h6 class="inLabelBoxStrong">
                            - 회원 탈퇴 시 또는 계약 만료 시까지
                            - 관계 법령에 따라 보존할 필요가 있는 경우 해당 법령에서 요구하는 기한까지 보유
                        </h6>
                    </div>
                </label>
            </p>
            <p>
                <label>
                    <input type="checkbox" id="checkBtn" class="inputCheckBtn">
                    위치기반 서비스 이용약관 동의<em>[선택]</em>
                    <div class="inLabelBox">
                        <h6 class="inLabelBoxStrong">
                            제1조 (목적)
                            본 약관은 TravelMaker(이하 "회사"라 함)이 제공하는 위치기반 서비스(이하 "서비스"라 함)의 이용조건 및 절차, 이용자와 회사의 권리, 의무, 책임사항 등을 규정함을 목적으로 합니다.
                        </h6>
                        <p class="inLabelBoxText">
                            제2조 (서비스 내용)
                            1. 회사는 위치기반 서비스를 통해 이용자의 위치 정보를 수집, 이용할 수 있습니다.
                            2. 위치기반 서비스는 이용자의 위치 정보를 기반으로 주변 정보 제공, 길 안내, 광고 등을 제공할 수 있습니다.
                            3. 위치기반 서비스는 이용자의 동의를 받아 수집된 위치 정보를 이용합니다.
                        </p>
                        <p class="inLabelBoxText">
                            제3조 (위치 정보 수집 및 이용)
                            1. 회사는 위치기반 서비스 이용 시 이용자의 위치 정보를 수집할 수 있습니다.
                            2. 수집된 위치 정보는 서비스 제공, 개선, 통계 분석 등의 목적으로 이용됩니다.
                            3. 회사는 수집된 위치 정보를 이용자의 동의 없이 제3자에게 제공하지 않습니다.
                        </p>
                        <p class="inLabelBoxText">
                            제4조 (위치 정보의 보관)
                            1. 회사는 위치 정보를 서비스 제공 기간 동안에만 보관합니다.
                            2. 회사는 위치 정보 보관 시 안전한 보관을 위해 최선의 노력을 다합니다.

                        </p>
                        <p class="inLabelBoxText">
                            제5조 (개인정보 보호)
                            위치 정보 수집 및 이용에 대한 개인정보 보호는 회사의 개인정보 처리 방침에 따릅니다.
                        </p>
                        <p class="inLabelBoxText">
                            제6조 (책임과 면책)
                            1. 이용자는 위치기반 서비스 이용 시 발생하는 일체의 책임을 부담합니다.
                            2. 회사는 위치기반 서비스 이용으로 인한 이용자의 손해에 대해 어떠한 책임도 지지 않습니다.
                        </p>
                        <p class="inLabelBoxText">
                            제7조 (분쟁의 해결)
                            본 약관에 관한 분쟁은 대한민국의 관할법원에 제소합니다.
                        </p>
                        <p class="inLabelBoxText">
                            제8조 (기타)
                            본 약관에 명시되지 않은 사항은 관련 법령 및 회사의 운영정책에 따릅니다.
                        </p>
                    </div>
                </label>
            </p>
        </div>
        <button type="button" id="nextBtn" class="btn btn-primary">다음</button>
    </div>
</div>


<script>
    window.addEventListener('DOMContentLoaded', (event) => {
        const checkAll = document.getElementById('checkAll');
        const inputCheckBtns = document.getElementsByClassName('inputCheckBtn');
        const nextBtn = document.getElementById('nextBtn');
        const necessaryBtn = document.getElementById('checkAllNecessary')

        // "전체 동의" 체크박스 클릭 이벤트 처리
        checkAll.addEventListener('change', function() {
            for (let i = 0; i < inputCheckBtns.length; i++) {
                inputCheckBtns[i].checked = this.checked;
            }

            if(this.checked){
                nextBtn.style.display = 'block'
            }
            else {
                nextBtn.style.display = 'none'
            }
        });
    });

    nextBtn.onclick = function(){
        location.href = '${cpath}/Member/join'
    }
</script>
</body>
</html>
