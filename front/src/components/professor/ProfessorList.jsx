import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Button, Col, Row, Spinner, Table } from 'react-bootstrap'
import { Link, useLocation, useNavigate } from 'react-router-dom'
import '../Pagination.css'
import Pagination from 'react-js-pagination'

const ProfessorList = () => {
  const location = useLocation();
  const navi = useNavigate();
  const search = new URLSearchParams(location.search);
  const query = search.get("query") ? search.get("query") : "";
  const page = search.get("page") ? parseInt(search.get("page")) : 1;
  const key = search.get("key") ? search.get("key") : "pcode";
  const size = 3;

  const [loading, setLoading] = useState(false);
  const [list, setList] = useState([]);
  const [total, setTotal] = useState(0);

  const getList = async () => {
    setLoading(true);
    const res = await axios.get(`/pro/slist.json?page=${page}&size=${size}&key=${key}&query=${query}`);
    console.log(res.data);
    setList(res.data.list);
    setTotal(res.data.total);
    setLoading(false);
  }

  useEffect(() => {
    getList();
  }, [location]);

  const onClickRow = (pcode) => {
    navi(`/pro/read/${pcode}`);
  }

  if (loading) return <div className='my-5 text-center'><Spinner /></div>
  return (
    <div className='my-5'>
      <h1 className='title'>교수목록</h1>
      <Row className='mb-3'>
        <Col>
          <span>검색수 : {total}명</span>
        </Col>
        <Col className='text-end'>
          <Link to="/pro/insert">
            <Button variant='dark' size='sm'>교수등록</Button>
          </Link>
        </Col>
      </Row>
      <div className='professorlist_table'>
        <Table hover bordered>
          <thead>
            <tr className='text-center'>
              <th>교수번호</th>
              <th>교수이름</th>
              <th>교수학과</th>
              <th>임용일자</th>
              <th>교수급여</th>
              <th>교수직급</th>
            </tr>
          </thead>
          <tbody>
            {list.map(p => (
              <tr key={p.pcode} onClick={()=>onClickRow(p.pcode)} style={{cursor:'pointer'}}>
                <td>{p.pcode}</td>
                <td>{p.pname}</td>
                <td>{p.dept}</td>
                <td>{p.fmtdate}</td>
                <td>{p.fmtsalary}</td>
                <td>{p.title}</td>
              </tr>
            ))}
          </tbody>
        </Table>
        {total > size &&
          <Pagination
            activePage={page}
            itemsCountPerPage={size}
            totalItemsCount={total}
            pageRangeDisplayed={5}
            prevPageText={"‹"}
            nextPageText={"›"}
            onChange={(page) => { navi(`/pro/list?page=${page}&size=${size}&key=${key}&query=${query}`) }} />
        }
      </div>
    </div>
  )
}

export default ProfessorList