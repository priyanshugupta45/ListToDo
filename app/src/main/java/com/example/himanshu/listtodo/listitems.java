package com.example.himanshu.listtodo;


public class listitems {

    int _sno;
    String _todoitem;

    public void set_sno(int _sno) {
        this._sno = _sno;
    }

    public void setTodoitem(String todoitem) {
        this._todoitem = todoitem;
    }

    public listitems(String todoitem) {
        this._todoitem = todoitem;
    }

    public int get_sno() {
        return _sno;
    }

    public String getTodoitem() {
        return _todoitem;
    }
}