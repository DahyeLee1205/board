document.addEventListener('DOMContentLoaded', () => {
    boardMainFunc();
});

function boardMainFunc(){
    getBoard();
    naviInit();
    postPreviewBtnEvent();
}

function naviInit(){
    document.getElementById("mainPage").addEventListener('click', function() {
        getBoard();
    });
}

function initGetBoard(){
    const paginationDiv = document.getElementById("pagination");
    if (paginationDiv) {
        paginationDiv.remove();
    }
    document.getElementById('boardList').innerHTML = '';
}

function getBoard(){
    initGetBoard();
    fetch('/board/getLatestBoardList.do')
        .then(response => {
            if (!response.ok) throw new Error('네트워크 응답이 실패했습니다.');
            return response.json();
        })
        .then(responseData => {

            const siteHeading = document.getElementById('site-heading');
            siteHeading.style.display = '';
            const postHeading = document.getElementById('post-heading')
            postHeading.style.display = 'none';

            const boardList = responseData.data;
            const boardContainer = document.getElementById('boardList');
            boardList.forEach(board => {

                const postDiv = document.createElement('div');
                postDiv.className = 'post-preview'; // id 설정
                postDiv.innerHTML = `
                        <!--<div class="post-preview">-->
                        <h3>${board.boardTitle}</h3>
                        <p class="post-meta">
                        <div class="post-num" value="${board.id}">
                        Posted by ${board.userNo} on ${board.createDate}</div>
                        <hr class="my-4" />
                    `;
                boardContainer.appendChild(postDiv);
            });
            
            // 더보기 생성
            const moreBoardDiv = document.createElement('div');
            moreBoardDiv.className = 'd-flex justify-content-end mb-4'
            moreBoardDiv.innerHTML = `
                <a class="btn btn-primary text-uppercase" id= "moreBoard">
                    Older Posts →
                </a>
            `;
            boardContainer.appendChild(moreBoardDiv);

            getMoreBoard();
        })
        .catch(error => console.error('Fetch 에러:', error));
}

function getMoreBoard(){
    const moreBoardButton = document.getElementById("moreBoard");

    if (moreBoardButton) {
        moreBoardButton.addEventListener('click', function() {
            getAllBoard(0, 4);
        });
    } else {
        console.error("moreBoard 요소가 존재하지 않습니다.");
    }
}

function getAllBoard(pageNo, pageSize) {
    fetch(`/board/getBoardList.do?pageNo=${pageNo}&pageSize=${pageSize}`)
        .then(response => {
            if (!response.ok) throw new Error('네트워크 응답이 실패했습니다.');
            return response.json();
        })
        .then(responseData => {

            const siteHeading = document.getElementById('site-heading');
            siteHeading.style.display = '';
            const postHeading = document.getElementById('post-heading')
            postHeading.style.display = 'none';

            const boardList = responseData.data.content;
            const boardContainer = document.getElementById('boardList');
            boardContainer.innerHTML = ''; // 기존 게시글 리스트 초기화

            boardList.forEach(board => {
                const postDiv = document.createElement('div');
                postDiv.innerHTML = `
                    <div class="post-preview">
                        <div class="post-preview">
                        <h3>${board.boardTitle}</h3>
                        <p class="post-meta">
                        <div class="post-num" value="${board.id}">
                        Posted by ${board.userNo} on ${board.createDate}</div>
                        <hr class="my-4" />
                    </div>
                `;
                boardContainer.appendChild(postDiv);
            });

            // 페이지네이션 처리
            const paginationDiv = document.createElement('div');
            paginationDiv.id = 'pagination';
            paginationDiv.style.textAlign = 'center';


            // 총 페이지 수와 현재 페이지 번호를 응답에서 추출
            const totalPages = responseData.data.page.totalPages;
            const currentPage = responseData.data.page.number;

            // 페이지 번호 버튼 생성
            let paginationHTML = '';
            for (let i = 0; i < totalPages; i++) {
                paginationHTML += `<button onclick="getBoardPages(${i}, ${pageSize})">${i + 1}</button>`;
            }

            // '이전' 버튼 생성
            if (currentPage > 0) {
                paginationHTML = `<button onclick="getBoardPages(${currentPage - 1}, ${pageSize})">◀</button>` + paginationHTML;
            }

            // '다음' 버튼 생성
            if (currentPage < totalPages - 1) {
                paginationHTML += `<button onclick="getBoardPages(${currentPage + 1}, ${pageSize})">▶</button>`;
            }

            paginationDiv.innerHTML = paginationHTML;
            document.getElementById("boardArea").appendChild(paginationDiv);

        })
        .catch(error => console.error('Fetch 에러:', error));
}

function getBoardPages(pageNo, pageSize){
    fetch(`/board/getBoardList.do?pageNo=${pageNo}&pageSize=${pageSize}`)
        .then(response => {
            if (!response.ok) throw new Error('네트워크 응답이 실패했습니다.');
            return response.json();
        })
        .then(responseData => {

            const siteHeading = document.getElementById('site-heading');
            siteHeading.style.display = '';
            const postHeading = document.getElementById('post-heading')
            postHeading.style.display = 'none';

            const boardList = responseData.data.content;
            const boardContainer = document.getElementById('boardList');
            boardContainer.innerHTML = ''; // 기존 게시글 리스트 초기화

            boardList.forEach(board => {
                const postDiv = document.createElement('div');
                postDiv.innerHTML = `
                    <div class="post-preview">
                        <div class="post-preview">
                        <h3>${board.boardTitle}</h3>
                        <p class="post-meta">
                        <div class="post-num" value="${board.id}">
                        Posted by ${board.userNo} on ${board.createDate}</div>
                        <hr class="my-4" />
                    </div>
                `;
                boardContainer.appendChild(postDiv);
            });

            // 페이지네이션 처리
            const paginationDiv = document.getElementById('pagination');
            paginationDiv.innerHTML = '';

            // 총 페이지 수와 현재 페이지 번호를 응답에서 추출
            const totalPages = responseData.data.page.totalPages;
            const currentPage = responseData.data.page.number;

            // 페이지 번호 버튼 생성
            let paginationHTML = '';
            for (let i = 0; i < totalPages; i++) {
                paginationHTML += `<button onclick="getBoardPages(${i}, ${pageSize})">${i + 1}</button>`;
            }

            // '이전' 버튼 생성
            if (currentPage > 0) {
                paginationHTML = `<button onclick="getBoardPages(${currentPage - 1}, ${pageSize})">◀</button>` + paginationHTML;
            }

            // '다음' 버튼 생성
            if (currentPage < totalPages - 1) {
                paginationHTML += `<button onclick="getBoardPages(${currentPage + 1}, ${pageSize})">▶</button>`;
            }

            paginationDiv.innerHTML = paginationHTML;
            document.getElementById("boardArea").appendChild(paginationDiv);

        })
        .catch(error => console.error('Fetch 에러:', error));
}
function postPreviewBtnEvent(){
    document.addEventListener('click', function (e) {
        const postPreview = e.target.closest('.post-preview');
        if (postPreview) {
            const postNum = postPreview.querySelector('.post-num');
            const postVal = postNum.getAttribute('value');
            getBoardDetail(postVal);
        }
    });
}

function getBoardDetail(boardNo){
    fetch(`/board/getBoardDetail.do?boardNo=${boardNo}`)
        .then(response => {
            if (!response.ok) throw new Error('네트워크 응답이 실패했습니다.');
            return response.json();
        })
        .then(responseData => {

            // 헤더 숨기기
            const siteHeading = document.getElementById('site-heading');
            siteHeading.style.display = 'none';
            const postHeading = document.getElementById('post-heading')
            postHeading.style.display = '';

            const boardDetail = responseData.data;

            initGetBoard();
            const boardContainer = document.getElementById('boardList');
            /*boardContainer.innerHTML = ''; // 기존 게시글 리스트 초기화*/

            document.getElementById('postTitle').innerHTML = boardDetail.boardTitle;
            document.getElementById('postUserId').innerHTML = boardDetail.userNo;
            document.getElementById('postDate').innerHTML = boardDetail.createDate;

            const postDiv = document.createElement('p');
            postDiv.innerHTML = boardDetail.boardContent;
            boardContainer.appendChild(postDiv);

        })
}





