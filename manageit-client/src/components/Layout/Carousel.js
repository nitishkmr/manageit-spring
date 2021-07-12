import React, { Component } from 'react';
import CreateProject from '../../img/CreateProject.png';
import ProjectBoard from '../../img/ProjectBoard.png';
import PTList from '../../img/PTList.png';
import PTList2 from '../../img/PTList2.png';
import SignUp from '../../img/SignUp.png';

class Carousel extends Component {
  render() {
    return (
      <div
        id="carouselExampleIndicators"
        className="carousel slide"
        data-ride="carousel"
        data-interval="2000"
      >
        <div className="carousel-inner">
          <div className="carousel-item active">
            <img className="" src={PTList} alt="First slide" />
          </div>
          <div className="carousel-item">
            <img className="" src={CreateProject} alt="Second slide" />
          </div>
          <div className="carousel-item">
            <img className="" src={ProjectBoard} alt="Third slide" />
          </div>
          <div className="carousel-item">
            <img className="" src={SignUp} alt="Fourth slide" />
          </div>
          <div className="carousel-item">
            <img className="" src={PTList2} alt="Fifth slide" />
          </div>
        </div>
        <a
          className="carousel-control-prev"
          href="#carouselExampleIndicators"
          role="button"
          data-slide="prev"
        >
          <span className="carousel-control-prev-icon" aria-hidden="true"></span>
          <span className="sr-only">Previous</span>
        </a>
        <a
          className="carousel-control-next"
          href="#carouselExampleIndicators"
          role="button"
          data-slide="next"
        >
          <span className="carousel-control-next-icon" aria-hidden="true"></span>
          <span className="sr-only">Next</span>
        </a>
      </div>
    );
  }
}

export default Carousel;
