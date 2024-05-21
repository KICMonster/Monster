/* global kakao */

import React, { useEffect, useRef } from 'react';
const apiKey = import.meta.env.VITE_GIS;
function MapContainer() {
    const mapRef = useRef(null); // DOM 접근을 위한 ref 생성

    useEffect(() => {
        const script = document.createElement('script');
        script.src = `//dapi.kakao.com/v2/maps/sdk.js?appkey=${apiKey}&autoload=false`;
        script.async = true;
        document.head.appendChild(script);


        script.addEventListener("load", () => {
            window.kakao.maps.load(() => {
                const container = document.getElementById("map");
                const options = {
                    center: new window.kakao.maps.LatLng(33.450701, 126.570667), // 초기 중심 좌표 (위도, 경도)
                    level: 3, // 지도 확대 레벨
                };
                new window.kakao.maps.Map(container, options);
            });
        });
    }, []);


    return (
        <div id="map" ref={mapRef} style={{ width: '500px', height: '400px' }}></div>
    );
}

export default MapContainer;