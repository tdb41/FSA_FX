(defun demo()
(setq fp (open "theString.txt" :direction :input))
(setq x (read fp "done"))
(State_0 x)
)
(defun State_0(x)
 (COND
((EQUAL 'x (CAR x)) (State_0(CDR x)))
((EQUAL 'y (CAR x)) (State_1(CDR x)))
 )
)

(defun State_1(x)
 (COND
((ATOM x) T)
((EQUAL 'x (CAR x)) (State_2(CDR x)))
 )
)

(defun State_2(x)
 (COND
((EQUAL 'x (CAR x)) (State_2(CDR x)))
((EQUAL 'y (CAR x)) (State_3(CDR x)))
 )
)

(defun State_3(x)
 (COND
((ATOM x) T)
((EQUAL 'x (CAR x)) (State_3(CDR x)))
((EQUAL 'z (CAR x)) (State_4(CDR x)))
 )
)

(defun State_4(x)
 (COND
((EQUAL 'x (CAR x)) (State_4(CDR x)))
((EQUAL 'a (CAR x)) (State_1(CDR x)))
 )
)

