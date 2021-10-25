# ExceptionHandler 고찰

ExceptionHandler이 어떻게 동작하는 지 알아볼 수 있는 프로젝트이다.

## 접근 방식
- ControllerAcceptanceTest에 각 요청이 작성되어 있다. 이를 하나씩 디버깅하는 방식으로 진행한다.
- 해당하는 `@ExceptionHandler`에 디버깅 포인트를 찍고 StackTrace를 확인한다.
  ![Intellij StackTrace](https://user-images.githubusercontent.com/49307266/138664704-2d97b617-865b-4b36-9982-44902bc35a9b.png)
- 실제 어떤 방식으로 ExceptionHandler가 저장되고 사용해 보는지 디버깅 포인트를 추가해 가며 진행한다.

## 탐구 과제 
실제 다음의 동작들이 어떤 이유로 동작하는지 확인해보기를 바란다.
1. Controller와 ControllerAdvice의 ExceptionHandler의 우선 순위
2. Controller의 적용된 ExceptionHandler의 적용 범위는 해당 Controller만을 관리하나?
3. ControllerAdvice의 basePackage를 적용해 주었을 때, 어떤 방식으로 basePackage 따라 ExceptionHandler가 작동되나?
4. ExceptionHandler에 ResponseStatus 어노테이션을 붙였을 때 vs ResponseEntity에 상태코드를 넣어주었을 때 우선 순위
   (Hint: ServletInvocableHandlerMethod의 invokeAndHandle() 메소드)
5. Exception에 ResponseStatus를 설정해주었을 때, 어떻게 동작하는지.
6. ResponseStatus 설정을 한 Exception과 ControllerAdvice 로직 중 어떤 것이 우선 순위를 가지는 지.



