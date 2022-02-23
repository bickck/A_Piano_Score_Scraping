#### IMSLP 악보 사이트에서 악보를 크로링하는 프로젝트


### ----------------------------------------------------  필요한 작업  -----------------------------------------------------------


#### 1. IMSLP 사이트에서 JSON으로 데이터를 제공, 데이터를 DB에 저장할 수 있는 형태로 바꾸는 작업 (완)

#### 2. IMSLP가 같고 있는 데이터 양을 확인하는 알고리즘 설계(완)
- 데이터를 얻기위해 걸리는 시간 : 2초
- 페이지 양 : 약 3만개 이상으로 생각됨
- 1페이지 당 데이터 양은 1000개 마지막 페이지 데이터 : N개로 추정
- 개선해야되는 점 : 코드가 깔끔하지 못하고 반복문을 2번 작업함 => 추후에 개선해야 된다고 

#### 3. 저장된 데이터를 효율적으로 탐색하는 작업이 필요함 (미완)

#### 4. 데이터 저장시 어떤 데이터를 저장하고 있는지 확인하는 로그 필요 (미완)

#### 5. 데이터 양을 미리 확인 후 몇개의 데이터가 저장되었는지 오류가 발생하면 어디서 발생했는지에 대한 모니터링이 필요(미완)

### -----------------------------------------------------------------------------------------------------------------------------
