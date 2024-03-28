import React, { useState } from 'react';

const OneProduct = () => {
  const [selectedBook, setSelectedBook] = useState(null);

  const books = [
    {
      id: 1,
      title: 'Book 1',
      description: 'This is the description of Book 1.',
      author: 'Author 1',
      price: 9.99,
    },
    {
      id: 2,
      title: 'Book 2',
      description: 'This is the description of Book 2.',
      author: 'Author 2',
      price: 14.99,
    },
    // Add more books here...
  ];

  const handleBookClick = (book) => {
    setSelectedBook(book);
  };

  return (
    <div>
      <h1>Book List</h1>
      <ul>
        {books.map((book) => (
          <li key={book.id} onClick={() => handleBookClick(book)}>
            {book.title}
          </li>
        ))}
      </ul>

      {selectedBook && (
        <div>
          <h2>{selectedBook.title}</h2>
          <p>{selectedBook.description}</p>
          <p>Author: {selectedBook.author}</p>
          <p>Price: ${selectedBook.price}</p>
        </div>
      )}
    </div>
  );
};

export default OneProduct;
