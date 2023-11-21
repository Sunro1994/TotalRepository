
$(function() {
    $('input[name="daterange"]').daterangepicker({
      opens: 'left'
    }, function(start, end, label) {
      console.log("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
    });
  });

  document.addEventListener("DOMContentLoaded", function() {
    // 이 곳에서 ResetBtn 및 ApplyBtn을 선택하고 다른 스크립트를 실행할 수 있습니다.
    const ResetBtn = document.querySelector('.ResetBtn');
    const ApplyBtn = document.querySelector('.ApplyBtn');
    const AreaCheckBoxs = document.querySelectorAll('div.LocationFilter .form-check-input');
    const TypeCheckBoxs = document.querySelectorAll('div.TypeFilter .form-check-input');
    console.log(TypeCheckBoxs)
    console.log(AreaCheckBoxs)
    const areaArr = [];
    const typeArr = [];
    ResetBtnHanlder = function(event) {
        AreaCheckBoxs.forEach(e=> e.checked=false)
    }
    ApplyBtnBtnHanlder= function(event) {
        AreaCheckBoxs.forEach(e=> {
            if(e.checked==true){
                console.log(e.nextElementSibling.innerText)
                areaArr.push(e.nextElementSibling.innerText)
            }
        })
        
        TypeCheckBoxs.forEach(e =>{
            if(e.checked == true){
                console.log(e.nextElementSibling.innerText)
                typeArr.push(e.nextElementSibling.innerText)
            }
        })
        console.log(areaArr,typeArr)
    }

    $.ajax({
        type:'POST',
        url : '${cpath}/lodge/getSelectedList',
        data : JSON.stringify(areaArr),
        contentType : 'application/json',
        success:function(resp) {    
            console.log(resp)
        }

    })

   ResetBtn.addEventListener('click',ResetBtnHanlder)
   ApplyBtn.addEventListener('click',ApplyBtnBtnHanlder)
});