
<h1>신규가입자 처리 페이지</h1>
<img width="931" alt="스크린샷 2025-06-20 오후 4 19 12" src="https://github.com/user-attachments/assets/3d4581b3-162e-46fc-855b-5b941cf2f668" /><br>
<h3>💻 개발환경</h3>
 - SpringBoot 2.7.18<br>
 - Java 8 (Amazon Corretto 1.8.0_452)<br>
 - IntelliJ IDEA 2025.1.1.1 (Ultimate Edition)<br>
 - H2 Database<br>

 <h3>☑️ 테스트 정보</h3>
 - 신규가입자 처리 페이지 접속 URL : http://127.0.0.1:8081/signup<br>
 - H2 Database 페이지 접속 URL : http://127.0.0.1:8081/h2-console<br>
 - H2 Database 로그인 정보<br>
 &ensp;-- Driver Class : org.h2.Driver<br>
 &ensp;-- JDBC URL : jdbc:h2:mem:testdb<br>
 &ensp;-- User Name : sa<br>
 &ensp;-- Password : 없음<br>

<h3>☑️ 아이디 제약사항</h3>
 - E-mail 양식을 사용한다.<br>
 - 최대 길이는 32 이다.<br>
 - 중복될 경우 alert로 오류메세지("아이디가 중복되었습니다")를 출력 한다.<br>

<h3>☑️ 비밀번호 제약사항</h3>
 - 영문 대문자, 영문 소문자, 특수문자, 숫자가 각각 하나 이상 포함되어야 한다.<br>
 - 입력된 '비밀번호'와 '비밀번호 확인'이 불일치 할 경우 alert가 출력 되어야 한다.<br>
 - 암호화 되어야 한다.<br>
 
<h3>☑️ 가입 버튼 제약사항 </h3>
 - '가입' 버튼을 클릭했을 때 '아이디 제약사항'과 '비밀번호 제약사항'을 검사 한다.<br>
 - 오류는 alert로 출력 한다.<br>
 - 제약사항을 모두 통과할 경우 완료메세지를 alert로 매세지("가입되셨습니다.")를 출력 한다.<br>



 
