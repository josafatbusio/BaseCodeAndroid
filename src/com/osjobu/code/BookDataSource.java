package com.osjobu.code;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oscar
 * Date: 29/06/12
 * Time: 10:19 AM
 * To change this template use File | Settings | File Templates.
 */

public class BookDataSource {

        // Database fields

        private MyDBAdapter dbHelper;
        private String[] allColumns = { Constants.BOOK_ID,
                                        Constants.BOOK_ISBN,
                                        Constants.BOOK_TITLE,
                                        Constants.BOOK_PUBLISHER,
                                        Constants.BOOK_IMAGE};

        public BookDataSource(Context context) {
            dbHelper = new MyDBAdapter(context);
        }

        public void open() throws SQLException {
             dbHelper.open();
        }

        public void close() {
            dbHelper.close();
        }

        public Book createBook(Book book) {
            ContentValues values = new ContentValues();
            values.put(Constants.BOOK_TITLE, book.getTitle());
            values.put(Constants.BOOK_ISBN, book.getIsbn());
            values.put(Constants.BOOK_PUBLISHER, book.getPublisher());
            values.put(Constants.BOOK_IMAGE, book.getImage());


            long insertId = dbHelper.getDb().insert(Constants.BOOK_TABLE, null,values);

            Cursor cursor = dbHelper.getDb().query(Constants.BOOK_TABLE, allColumns, Constants.BOOK_ID+ " = " + insertId, null, null, null, null);
            cursor.moveToFirst();
            Book newBook = cursorToBook(cursor);
            cursor.close();
            return newBook;
        }

        //---deletes a particular title---
        public boolean deleteBook(Book book) {
            long id = book.getId();
            System.out.println("Comment deleted with id: " + id);
           return  dbHelper.getDb().delete(Constants.BOOK_TABLE,Constants.BOOK_ID  + " = " + id, null) > 0;
        }

        public List<Book> getAllComments() {
            List<Book> books = new ArrayList<Book>();

            Cursor cursor = dbHelper.getDb().query(Constants.BOOK_TABLE,allColumns, null, null, null, null, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Book book = cursorToBook(cursor);
                books.add(book);
                cursor.moveToNext();
            }
            // Make sure to close the cursor
            cursor.close();
            return books;
        }

    //---retrieves a particular title---
    public Book getTitle(long rowId) throws SQLException
    {
        Book book=null;
        Cursor mCursor =dbHelper.getDb().query(true, Constants.BOOK_TABLE, allColumns, Constants.BOOK_ID + "=" + rowId,
                null,
                null,
                null,
                null,
                null);
        if (mCursor != null) {
            mCursor.moveToFirst();
            book = cursorToBook(mCursor);
        }
        return book;
    }

        private Book cursorToBook(Cursor cursor) {
            Book book = new Book();
            book.setId(cursor.getLong(0));
            book.setIsbn(cursor.getString(1));
            book.setTitle(cursor.getString(2));
            book.setPublisher(cursor.getString(3));
            book.setImage(cursor.getBlob(4));
            return book;
        }
}
