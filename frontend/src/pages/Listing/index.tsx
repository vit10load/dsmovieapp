import Pagination from "components/pagination";
import MovieCard from "components/MovieCard";
import axios from "axios";
import { BASE_URL } from "utils/requests";
import React, { useEffect, useState } from 'react';
import { MoviePage } from "types/movie";

function Listing() {

    const [API_DATA, setApiData] = useState([]);

    const [pageNumber, setPageNumber] = useState(0);

    useEffect(() => {
        
        axios.get(`${BASE_URL}/movies`).then((response) => {
            setApiData(response.data);
            const data = response.data as MoviePage;
            setPageNumber(response.data)
            console.log(data.number);
        });
        
    }, []);
    

    return (
        <>
            <Pagination></Pagination>
            <div className="container">
                <div className="row">
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard></MovieCard>
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard></MovieCard>
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard></MovieCard>
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard></MovieCard>
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard></MovieCard>
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard></MovieCard>
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard></MovieCard>
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard></MovieCard>
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard></MovieCard>
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard></MovieCard>
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard></MovieCard>
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard></MovieCard>
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard></MovieCard>
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard></MovieCard>
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard></MovieCard>
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard></MovieCard>
                    </div>
                </div>
            </div>
        </>

    );
}

export default Listing;