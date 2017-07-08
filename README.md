# 코딩 교육 센터 후기 커뮤니티

## 알게된 점

### Webpack
* ExtractTextPlugin으로 추출할 수 있는 것은 **entry 포인트(app.js)에 지정된 대상의 의존성들만**가능하다
  * 무작정 css를 불러올순 없으니, app.js에서 css들을 import하는 scss파일을 import하도록 지정해야함
  
### 필요한 기능

* Hash Tag 및 검색
  * Course <-> Map <-> Hash 로 관계
* Github 로그인
* 코스가 삭제되어도 리뷰는 삭제되지 않는다
  * 강사 조회 교육센터 조회시 보여줄 수 있도록