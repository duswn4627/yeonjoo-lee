<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top" id="nav">
		<ul class="nav">
		  <li class="nav-item">
		    <a class="nav-link" href="${cp }/list1">전체오름차순</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="${cp }/list2">베스트순</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="#">Link</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link disabled" href="#">Disabled</a>
		  </li>
		</ul>
	</nav>
	  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="${cp }/">Go Book</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="${cp }/">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${cp }/list1">리스트테스트1</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${cp }/list2">베스트순</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">LINK2</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
	
</div>