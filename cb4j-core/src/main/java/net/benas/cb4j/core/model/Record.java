/*
 * The MIT License
 *
 *  Copyright (c) 2012, benas (md.benhassine@gmail.com)
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package net.benas.cb4j.core.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A model class representing a CSV record
 * @author benas (md.benhassine@gmail.com)
 */
public class Record {

    /**
     * The record number in the file
     */
    private long number;

    /**
     * The fields separator
     */
    private String separator;

    /**
     * The record fields
     */
    private List<Field> fields;

    public Record(long number, String separator) {
        this.number = number;
        this.separator = separator;
        this.fields = new ArrayList<Field>();
    }

    /**
     * Getter for a field by its index in the record
     * @param index the field index
     * @return The Field with index index
     */
    public Field getFieldByIndex(int index) {
        if ( index < 0 || index > fields.size() )
            throw new IndexOutOfBoundsException("Index " + index + " is out of bound of fields list");
        return fields.get(index);
    }

    /**
     * Getter for a field's content by its index in the record
     * @param index the field index
     * @return The Field's content with index index
     */
    public String getContentByIndex(int index) {
        if ( index < 0 || index > fields.size() )
            throw new IndexOutOfBoundsException("Index " + index + " is out of bound of fields list");
        return fields.get(index).getContent();
    }

    /**
     * Getter for the field content as a String
     * @return The field content as String
     */
    public String getContentAsString() {
        StringBuilder sb = new StringBuilder();
        for (Field field : fields){
            sb.append(field.getContent());
            sb.append(separator);
        }
        return sb.toString();
    }

    public List<Field> getFields() {
        return fields;
    }

    public long getNumber() {
        return number;
    }
}
