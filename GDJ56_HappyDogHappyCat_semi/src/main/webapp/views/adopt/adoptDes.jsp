<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="<%=request.getContextPath() %>/js/jquery-3.6.1.min.js"></script> 
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script>
  Kakao.init('b5705da8bbf6d5f007956cd8575caa16'); // 사용하려는 앱의 JavaScript 키 입력
</script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>상세페이지</title>
</head>
<style>
	#content div{
            text-align: center;
        }
        #imgsbar img{
            width: 200px;
            height: 250px;
            opacity: 0.5; 
        }
    div#title{
        text-align: center;
        border-bottom: 2px solid rgb(194, 192, 192);
        width: 1000px;
        margin: 0 auto;
    }
    div#imgs{
        text-align: center;
    }
    div#description>table, td, th{
        margin:auto;
        border : 1px solid rgb(215, 211, 211);
        border-collapse : collapse;
    }
    div#description>table th{
        background-color: rgba(220, 220, 220, 0.612);
    }
    div#description>table{
        width: 800px;
        height: 200px;
        text-align: center;
    }
    div#detail{
        text-align: center;
    }
    div#detailTitle{
        text-align: center;
        border-top: 2px solid rgb(194, 192, 192);
        width: 700px;
        margin: 0 auto;
    }
    div#detailTitle h2{
        color: rgb(59, 120, 235);
    }
    div#detail img{
        width: 350px;
        height: 250px;
    }
    div#adp_btn{
        text-align: center;
    }
    div#adp_btn button{
        width: 350px;
        height: 60px;
    }
    div#adp_btn p{
        font-weight: 6px;
        letter-spacing: 5px;
        font-size: large;
        margin: auto;
    }
	.sideBanner {
        position: absolute;
        width: 140px;
        height: 140px;
        top: 50px;
        right: 20px;
        border-radius: 80px;
        border: solid 2px rgb(215, 211, 211);
    }
    #sideBanner-inner{
        text-align: center;
    }
    #pick{
        cursor: pointer;
    }
    #btnlistdiv{
            width:900px; 
            height:100px; 
            margin: auto;
        }
        #btnlist{
            width: 80px;
            height: 38px;
            float: right;
        }
</style>
<body>
    <section id="content">
	    <div id="imgsbar" style="width: 100%; height: 250px; background-color: rgba(211, 211, 211, 0.516); display: flex;">
	            <img src="<%=request.getContextPath() %>/images/adopt/Q.jfif" alt="" style="margin-right: auto;">
	            <div id="text" >
	                <br><br>
	                <h1>입양상세페이지</h1>
	                 <p>해피캣 해피독에서는 안락사없는 동물 보호소이므로<br>
	                    안전하게 분양받으실 수 있습니다.<br>
	                    많은 관심부탁드립니다</p>
	            </div>
	            <img src="<%=request.getContextPath() %>/images/adopt/S.jfif" alt="" style="margin-left: auto;">
	     </div>
	     <br><br>
        <div id="title">
            <h2>[강아지]웰시코기 궁딩이 무료입양</h2><br>
        </div>
        <br><br>
        
        <div id="imgs">
            <img src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt="" width="350" height="250">
        </div>
        <br><br>

        <div id="description">
            <table >
                <tr>
                    <th>견종</th>
                    <td>웰시코기</td>
                    <th>나이</th>
                    <td>8개월</td>
                </tr>
                <tr>
                    <th>성별</th>
                    <td>남</td>
                    <th>중성화여부</th>
                    <td>x</td>
                </tr>
                <tr>
                    <th>기본 예방접종 유무</th>
                    <td colspan="3">
                        <input type="checkbox" value="광견병" checked onclick="return false;">광견병
                        <input type="checkbox" value="코로나장염" onclick="return false;">코로나장염
                        <input type="checkbox" value="켄넬코프" onclick="return false;">켄넬코프
                        <input type="checkbox" value="인플루엔자" checked onclick="return false;">인플루엔자
                        <input type="checkbox" value="항체가검사" checked onclick="return false;">항체가검사
                        <input type="checkbox" value="종합백신" checked onclick="return false;">종합백신
                    </td>
                </tr>
                <tr>
                    <th>특이사항</th>
                    <td colspan="3">
                        슬개골이 안좋아서 점프를 조심해야합니다
                    </td>
                </tr>
                <tr>
                    <th>보호소로 오게 된 이유</th>
                    <td colspan="3">
                        모든가족들이 나가면 너무 많이 짖어 민원이 들어와서 더 이상 키울수 없습니다
                    </td>
                </tr>
            </table>
        </div>
        <br><br><br><br>
        <div id="detail">
            <div id="detailTitle"><br>
                <h2>HAPPY DOG HAPPY CAT</h2>
                <h3>무료입양</h3>
            </div>
            <video src="./video/KakaoTalk_20221207_152317915.mp4" controls width="400" height="400" poster="./img/images.jfif"></video>
            <br><br><br>
            <p>해피캣 해피독에서는 안락사없는 동물 보호소이므로<br>
                안전하게 분양받으실 수 있습니다.<br>
                많은 관심부탁드립니다.</p>
            <br><br>
            <img src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt=""><br><br><br><br>
            <img src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt=""><br><br><br><br>
        </div>
        <div id="checklist">
            <div id="detailTitle"><br>
                <h2>HAPPY DOG HAPPY CAT</h2>
                <h3>입양시 체크리스트</h3><br>
                <button type="button" class="btn btn-outline-primary" onclick="checkList();">체크리스트 확인하기</button> &nbsp;
                <input type="checkbox" id="ckck" value="checklist" onclick="return false;">필수
            </div>
        </div>
        <br><br>
        <div id="adp_btn">
            <button type="button" class="btn btn-primary" onclick="apt_form();"><p>입양하기</p></button>
        </div>
        <br>
        <div id="btnlistdiv">
                <button id="btnlist" type="button" class="btn btn-secondary btn-sm disabled"><p>글목록</p></button>
        </div>
	    <br>
	    <div class="sideBanner">
	        <div id="sideBanner-inner">
	            <br>
	            <h2 id="pick" onclick="clickpick(event);">🤍</h2> <!--  -->
	            <h2 id="share">
	            <a id="kakaotalk-sharing-btn" href="javascript:shareMessage()"> 
	            <img id="kakao-share" src="<%=request.getContextPath() %>/images/adopt/free-icon-share-3989188.png" alt="" width="33" height="33" >
	            </a>
	            </h2>
	        </div>
      </div>
</body>

<script>
	//카카오톡 공유하기
	function shareMessage() {
    Kakao.Link.sendDefault({
      objectType: 'feed',
      content: {
        title: 'HAPPYDOG HAPPYCAT',
        description: '사지말고 입양하세요',
        imageUrl:
          'https://ifh.cc/g/Ar5Jwk.png',
        link: {
          webUrl: '웹 링크',
        },
      },
      buttons: [
        {
          title: '자세히보기',  
          link: {
            webUrl: 'http://localhost:9090/happy/views/adopt/adoptDes.jsp',
          },
        },
      ],
    })
  }

	const clickpick=(e)=>{
	    console.log($(e.target).html());
	    if($(e.target).html()=='🤍'){
	        $("#pick").html("❤️");
	    }else{
	        $("#pick").html("🤍");
	    }
	}
	
	// 기본 위치(top)값
	var floatPosition = parseInt($(".sideBanner").css('bottom'));
	
	// scroll 인식
	$(window).scroll(function() {
	
	// 현재 스크롤 위치
	var currentTop = $(window).scrollTop();
	var newPosition = currentTop + floatPosition + "px";
	
	//이동 애니메이션
	$(".sideBanner").stop().animate({
	        "top" : newPosition
	    }, 500);
	}).scroll();
	
    const checkList=()=>{
    	//const title="checkList";
    	popup=open("<%=request.getContextPath()%>/adopt/adoptdespopup.do",title,"width=650 height=500 top=50, left=500");
    }
    
    const apt_form=()=>{
    	const ckck=document.getElementById("ckck").checked;
    	if(!ckck){
    		alert('체크리스트를 확인하고 오세요');
    	}else{
    		location.assign("/adopt/adoptdespopup.do");
    	}
    }
    
</script>
</html>