console.log('Hello Codeit!')
console.log(15)

// 사칙연산 가능
console.log(10 + 5)
console.log(3 * 5)

// 두 개 이상의 명령을 한 줄에 적기 위해서는 세미콜론 필수
console.log(10 + 5); console.log(20 - 5)

// 변수 선언
let espressoPrice = 3000;
let lattePrice = 4300;

console.log(espressoPrice * 2);
console.log(espressoPrice + lattePrice);
console.log(lattePrice * 3);

// 함수 선언
function greetings() {
    console.log('Hi');
    console.log('안녕');
;}
// 함수 호출
greetings();

function welcome(name) {
    console.log('안녕하세요 ' + name + '님!');
};
welcome('abc');



// BMI 계산
function bmiCalculator(name, weight, tall) {
    let bmi = weight / (tall * tall / 10000);
    console.log(name + '님의 체질량지수는 ' + bmi + '입니다.');
  };
  
// 테스트
bmiCalculator('홀쭉이', 43.52, 160);
bmiCalculator('코린이', 61.25, 175);
bmiCalculator('통통이', 77.76, 180);


// 예금 1년 뒤에 받을 돈
function interestCalculator(amount, term, rate) {
    return amount * term * rate/100;
  }
  
// 조건 입력 테스트
let myMoney = 3650000; // 맡긴 금액 (원)
let saveTerm = 1; // 맡기는 기간 (년)
let interestRate = 4; // 이자율 (%)

// 수령액 계산 테스트
let myInterest = interestCalculator(myMoney, saveTerm, interestRate);
let totalMoney = myMoney + myInterest;

// 출력 테스트
console.log('맡긴 금액은 ' + myMoney + '원 입니다.');
console.log('이자는 ' + myInterest + '원 입니다.');
console.log('최종 받을 금액은 ' + totalMoney + '원 입니다.');
