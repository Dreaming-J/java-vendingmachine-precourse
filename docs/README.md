# 🎮 흐름도

---

- [ ] 자판기 보유 금액 입력
- [ ] 보유 금액과 동일한 무작위 동전 생성 후 출력
- [ ] 상품명, 가격, 수량 입력
- [ ] 입력 정보에 따른 정보 입력
- [ ] 투입 금액 입력
    - 동전 생성 X
- [ ] 상품 구매
- [ ] 잔돈으로 지급될 동전 계산 후 출력

# ⚙ 기능

---

- 자판기
    - [ ] 보유 금액으로 동전 생성
    - [ ] 잔돈 반환
        - 조건: 남은 금액 < 최저 가격 || 모든 상품 소진
        - 최소 개수의 동전으로 돌려줌
        - 잔돈을 반환할 수 없는 경우 가능한 금액만 반환
            - 반환되지 않은 금액은 자판기에 남음
    - [ ] 상품, 수량 저장
        - 수량: 최소 1개
    - [ ] 투입 금액 저장
    - [ ] 상품 구매
        - 구매한 상품 수량, 투입 금액 감소
- 동전
- 상품
    - [x] 상품명, 가격
        - 가격: 최소 100원, 10원 단위
- 돈

## 입출력

- 입력
    - [ ] 모든 입력 예외 처리 후 재입력
        - `IllegalArgumentException` 발생
        - "[ERROR]"로 시작하는 메시지 출력 후 재입력
    - [ ] 자판기 보유 금액 입력
        - 10원 단위
    - [ ] 상품명, 가격, 수량 입력
        - 정규표현식: 상품명 - 최소 1글자, 가격 & 수량 - 숫자만 가능
        - 각각은 쉼표(,)로 구분
        - 개별 상품은 대괄호([])로 묶어 세믹콜론(;)으로 구분
    - [ ] 투입 금액 입력
        - 10원 단위
    - [ ] 구매할 상품명 입력
- 출력
    - [ ] 자판기가 보유한 동전 출력
    - [ ] 남은 투입 금액 출력
    - [ ] 잔돈 출력

# ✔ 체크 리스트

---

- [ ] JAVA 17버전
- [ ] ./gradlew.bat clean test 통과
- [ ] 입/출력 형식은 예와 동일한가
- [ ] readLine() 사용
- [ ] indent depth는 2까지만 허용했는가
- [ ] 3항 연산자를 쓰지 않았는가
- [ ] 메서드는 한 가지 일만 했는가
- [ ] 기능 목록을 테스트 코드로 확인했는가
- [ ] 메서드 라인은 15라인 이하인가
- [ ] else, switch/case 예약어를 쓰지 않았는가
- [ ] 단위 테스트 구현