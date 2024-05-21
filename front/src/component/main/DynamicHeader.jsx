import React, { useState, useEffect } from 'react';
import TopNavBar from './TopNavBar';
import SearchBar from './SearchBar';
import LoginButton from './LoginButton';


function DynamicHeader() {
  const [searchTerm, setSearchTerm] = useState('');
  const [isShrunk, setShrunk] = useState(false);


  const handleSearchChange = (event) => {
    setSearchTerm(event.target.value);
  };

  useEffect(() => {
    const handleScroll = () => {
      setShrunk(window.scrollY > 100);
    };

    window.addEventListener('scroll', handleScroll);
    return () => {
      
      window.removeEventListener('scroll', handleScroll);
    };
  }, []);

 
  return (
    <header className={isShrunk ? 'header shrink' : 'header expand'}>
      <div className="header-content">
        <TopNavBar isShrunk={isShrunk} /> 
        <SearchBar />
        <LoginButton />
      </div>
    </header>
    
  );
}

export default DynamicHeader;



// search-button search-button-color