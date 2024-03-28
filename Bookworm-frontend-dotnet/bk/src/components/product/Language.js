import { useEffect, useState } from "react";

export default function Language({ setSelectedLanguage, setSelectedGenre }) {
  const [languageType, setLanguageType] = useState([]);
  const [genreType, setGenreType] = useState([]);
  //const [selectedLanguage, setSelectedLanguage] = useState(null);

  useEffect(() => {
    fetch("https://localhost:7134/api/Language/getAll")
      .then((res) => res.json())
      .then((data) => setLanguageType(data));
  }, []);
  useEffect(() => {
    fetch("https://localhost:7134/api/Genre/getGenres")
      .then((res) => res.json())
      .then((data) => setGenreType(data));
  }, []);

  const handleLanguageClick = (languageId) => {
    setSelectedLanguage(languageId);
    // console.log(languageId);
  };
  const handlegenreclick = (genreId) => {
    console.log(genreId);
    setSelectedGenre(genreId);
  };
  return (
    <>
      <div style={{ display: "flex"}}>
        <div
          className="justify-content-start"
          aria-label="Toolbar with Button groups"
          style={{ marginRight: "50px" }}
        >
          <div
            style={{
              paddingLeft: "10px",
              marginBottom: "10px",
              fontWeight: "bold",
            }}
          >
            LANGUAGES
          </div>
          <div aria-label="Basic example">
            {/* <div style={{ display: 'flex', flexDirection: 'row', flexWrap: 'wrap' }}> */}

            {languageType.map((language) => (
              <div style={{ paddingLeft: "30px", marginBottom: "10px" }}>
                <input
                  type="radio"
                  name="language"
                  key={language.languageId}
                  variant="secondary"
                  onClick={() => handleLanguageClick(language.languageId)}
                />
                <label>{language.languageDesc}</label>
              </div>
            ))}
          </div>
        </div>
      {/* </div>
      <div style={{ display: "flex", justifyContent: "space-between" }}> */}
        <div
          className="justify-content-start"
          aria-label="Toolbar with Button groups"
        >
          <div
            style={{
              paddingLeft: "10px",
              marginBottom: "10px",
              fontWeight: "bold",
            }}
          >
            GENRES
          </div>
          <div aria-label="Basic example">
            {/* <div style={{ display: 'flex', flexDirection: 'row', flexWrap: 'wrap' }}> */}

            {genreType.map((genre) => (
              <div style={{ paddingLeft: "30px", marginBottom: "10px" }}>
                <input
                  type="radio"
                  name="genre"
                  key={genre.genreId}
                  variant="secondary"
                  onClick={() => handlegenreclick(genre.genreId)}
                />
                <label>{genre.genreDesc}</label>
              </div>
            ))}
          </div>
        </div>
      </div>
    </>
  );
}
