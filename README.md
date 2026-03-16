<h1>import 할 때 보세용</h1>

<ol>
  <li>git bash 접속 후 워크스페이스로 경로 이동</li>
  <li>git clone https://github.com/sohyeon59/recruit.git로 받아오기</li>
  <li>같은 워크스페이스로 STS접속</li>
  <li>접속 후 File -> import -> Gradle -> Exiting Gradle Project</li>
  <li>Project root directory의 Browse 클릭 후 Clone으로 받은 폴더 선택(recruit)</li>
  <li>Finish 누르면 Spring Starter Project 만들어 짐.</li>
  <li>이건 선택(com.example.recruit.RecruitApplication.java 우클릭 후 Run As -> Spring boot App 클릭 {전 안했어요})</li>
</ol>


<h3>Buile.Gradle</h3>
<p>plugin에 [ id 'eclipse' ] 추가(대괄호 빼고)
<p>가장 아래에 <br>
  eclipse {<br>
    wtp {<br>
        facet {<br>
            facet name: 'jst.web', version: '6.0'<br>
        }<br>
    }<br>
}<br>
</p>
└>이거 추가하면 Build Path에서 Dynamic Web Module 버전이 자동으로 2.4로 바뀌는걸 6.0으로 고정시켜서 막아줍니다.
