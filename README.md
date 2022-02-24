#### IMSLP 악보 사이트에서 악보를 크로링하는 프로젝트

※ 본격적인 기록을 시작한 날짜는 2월 초반 


### -------------------------------  필요한 작업  ------------------------------------


#### 1. IMSLP 사이트에서 JSON으로 데이터를 제공, 데이터를 DB에 저장할 수 있는 형태로 바꾸는 작업 (완)
 - 데이터를 JSONParser을 사용하여 변형 후 DB에 저장
 - 

#### 2. IMSLP가 가지고 있는 데이터 양을 확인하는 알고리즘 설계(완)

-> 선형탐색을 하면 약 10시간 이상이 소요될 것이라고 생각됨 -> 이분 탐색을 적용 후 10분 미만으로 탐색 가능
- 데이터를 얻기위해 걸리는 시간 : 2초
- 페이지 양 : 약 3만개 이상으로 생각됨
- 1페이지 당 데이터 양은 1000개 마지막 페이지 데이터 : N개로 추정
- 개선해야되는 점 : 코드가 깔끔하지 못하고 반복문을 2번 작업함 => 추후에 개선해야 된다고 생각된다.
- 기록 : https://3d1935.tistory.com/86

#### 3. 저장된 데이터를 효율적으로 탐색하는 작업이 필요함


#### 4. 데이터 저장시 어떤 데이터를 저장하고 있는지 확인하는 작업과 모든 데이터를 가져오는 메서드에 로그 필요 (미완) => 개선 필요
- 2022-02-22 : AOP 표현식 테스트 후 메서드 적용에서 AOP가 적용이 안됌
- 2022-02-23 : @PointCut -> @Around로 변경하였으며 AOP가 적용이 됨.. 이유는 몰루.. AOP에 대한 지식이 부족한 부분 확인됨
- 2022-02-24 : 완성은 되었지만 아직 데이터를 저장할 DB설계가 완벽하지 않기에 개선이 필요

#### 5. 데이터 양을 미리 확인 후 몇개의 데이터가 저장되었는지 오류가 발생하면 어디서 발생했는지에 대한 모니터링이 필요

#### 6. 어떠한 이유로 중단될 경우 로그에 마지막으로 저장된 위치를 찾아 재시작 
### ----------------------------------------------------------------------------------

<br>
<br>
<br>

### ----------------------- 필요하다고 생각되는 공부  -----------------------
#### Junit <= 처음 써보는 메서드도 테스트를 해야하고 만든 코드도 테스트를 해야하는데 가끔씩 어디에 코드를 만들었는지 헷갈리고 오래걸림 만약에 배운다면 더 빨리 테스트를 진행할 수 있지 않을까 
