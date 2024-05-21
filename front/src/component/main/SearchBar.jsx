import React, { useState, useEffect } from 'react';

function SearchBar() {
    const [searchQuery, setSearchQuery] = useState(""); // 검색어 상태 추가
    
    // 검색어 변경 핸들러
    const handleInputChange = (event) => {
        setSearchQuery(event.target.value);
    };

    // 검색 폼 제출 핸들러
    const handleSubmit = (event) => {
        event.preventDefault();
        // 여기에 검색 처리 로직을 추가하세요
        console.log("검색어:", searchQuery);
        // 검색 처리 로직을 완료한 후에 필요하면 결과를 업데이트하세요
    };

    return (
        <div className="search-form-container">
            <form onSubmit={handleSubmit} className="search-form">
            <input
                type="text"
                value={searchQuery}
                onChange={handleInputChange}
                placeholder="검색어를 입력하세요..."
                className="search-input"
                />
            <button type="submit" className="search-button">검색</button>
            </form>
        </div>
    );

}

export default SearchBar;