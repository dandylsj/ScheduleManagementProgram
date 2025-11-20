# CH 3 일정 관리 앱 

## 프로젝트 소개

이전에 만든 CRUD를 기초로 추가로 유저 테이블을 만들어  user_id 라는 연관관계를 만들어주어 일정을 만들때 
유저 테이블의 내용을 어떻게 참조하여 제작할 것인지,  그리고 거의 모든 사이트에서 사용하는 기본적인 회원가입,로그인,로그아웃 기능을
추가하여 어떤방식으로 인증 인가를 시키는지에 대해서 알 수 있었습니다.

회원가입을 한 유저만 일정을 작성할 수 있게 만들고 또 다른 회원이 내가 작성한 일정을 수정,삭제 하지 못하도록 하기 위하게 만들었습니다.
세션에 대한 방식을 조금 이해할 수 있었습니다.


<br>

## 기술 스택

**Language**: Java Corretto 17 

**Framwork**: SpringBoot

**Database** : MYSQL

**Build**:Gradle

**ORM**: Spring Data JPA

**IDE**: IntelliJ IDEA 

<br>


## 개발 기간

2025.11.03 ~ 2025.11.06


<br>

## 와이어 프레임

POST 요청에 대한 데이터의 흐름을 간략하게 작성해 봤습니다.
<img width="3823" height="1968" alt="image" src="https://github.com/user-attachments/assets/9766ee71-0755-47d5-add0-cefd0d13f4ea" />


## ERD 
<img width="2047" height="563" alt="스크린샷 2025-11-19 112605" src="https://github.com/user-attachments/assets/9849a6ae-1103-4981-b26c-29ee0cd49c96" />



## API 명세서

아래 사진과 같이 사이드 보기로들어가면 자세히 볼 수 있습니다.

[API 명세서 보러가기](https://www.notion.so/2a24d058410381cc94b7f03cd03dd60d?v=2a24d058410381fe9420000c2f60ac76)



<br>


[트러블슈팅 보러가기]([https://velog.io/write?id=1c049713-a0cf-4c6e-9050-9c297f8725ef](https://velog.io/@lsjyahoo/%EC%8A%A4%EC%BC%80%EC%A4%84-%EC%95%B1-%EB%A7%8C%EB%93%A4%EA%B8%B0-%ED%8A%B8%EB%9F%AC%EB%B8%94-%EC%8A%88%ED%8C%85-%ED%95%A9%EB%B3%B8)
