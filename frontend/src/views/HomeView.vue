<template>
  <div class="jumbotron text-center">
    <h1 class="display-4">개발자 툴킷</h1>
    <p class="lead">개발자를 위한 다양한 유틸리티 도구 모음</p>
    <hr class="my-4">
    <p>단위 변환, 정규식 테스트 등 개발 작업에 유용한 도구들을 사용해보세요.</p>

    <div class="row mt-5">
      <div class="col-md-6">
        <div class="card mb-4">
          <div class="card-body text-center">
            <h3 class="card-title">단위 변환기</h3>
            <p class="card-text">진수 변환, Base64 인코딩/디코딩, 타임스탬프 변환 등 다양한 변환 도구</p>
            <router-link to="/converter" class="btn btn-primary">사용하기</router-link>
          </div>
        </div>
      </div>

      <div class="col-md-6">
        <div class="card mb-4">
          <div class="card-body text-center">
            <h3 class="card-title">정규식 테스터</h3>
            <p class="card-text">정규식 패턴을 테스트하고 결과를 확인할 수 있는 도구</p>
            <router-link to="/regex" class="btn btn-primary">사용하기</router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
