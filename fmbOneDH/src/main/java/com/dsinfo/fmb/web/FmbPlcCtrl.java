package com.dsinfo.fmb.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dsinfo.fmb.service.*;
import com.dsinfo.bcf.service.*;

@RestController
public class FmbPlcCtrl {
	private static final Logger log = LoggerFactory.getLogger(FmbPlcCtrl.class);
	
	/**
	 * MyBatis활용을 위한 최상위 객체
	 **/
	//Autowired:spring에서 자동 생성 및 소멸을 관리
	@Autowired
	private MBcfBizService mBcfBizService;
	
	/*
	 * PLCList를 가져오는 VO
	 * @param id : selectFmbPlc
	 * @param : FmbPlcParamVO
	 * @exception : Exception 
	 * @return: FmbPlcVO
	 */
    @SuppressWarnings("unchecked")
    //4.매핑된 주소를 통해 요기로 이동
	@RequestMapping(value = "/bas/selectFmbPlc.do", method = RequestMethod.POST)
	public ResponseEntity<List<FmbPlcVO>> selectFmbPlc(@RequestBody  FmbPlcParamVO vo)  {
    	//RequestBody : JSON형태로 보낸 vo를 컬럼명이 똑같으면 FmbPlcParamVO형태로 알아서 매핑,변환
		List<FmbPlcVO> fmbPlcVO = null;
		System.out.println("FmbPlc.do로 이동");
		try {
			//mBcfBizService : select, insert, delete, update 구문과 vo를 정형화 해놓음
			//
			//5. sql-bas-info.xml의  id가 selectFmbPlc인 select 실행
		
			fmbPlcVO = (List<FmbPlcVO>) mBcfBizService.select("sql-bas-info.selectFmbPlc",vo);
			 
			System.out.println("vo" +vo);
	/*		log.info(vo.getEqptCd());
			log.error(vo.getEqptCd());*/
			
			return new ResponseEntity<List<FmbPlcVO>>(fmbPlcVO, HttpStatus.OK);
			//7.응답받은 result 리턴
		} catch (Exception ie) {
			log.error("FmbPlcController:selectFmbPlc=>" +  ie.toString());
			return new ResponseEntity<List<FmbPlcVO>>(fmbPlcVO, HttpStatus.OK);
		}
	}
	 @RequestMapping(value = "/bas/selectFmbPlcAlarm.do", method = RequestMethod.POST)
		public ResponseEntity<List<FmbPlcVO>> selectFmbPlcAlarm(@RequestBody  FmbPlcParamVO vo)  {
	    	//RequestBody : JSON형태로 보낸 vo를 컬럼명이 똑같으면 FmbPlcParamVO형태로 알아서 매핑,변환
			List<FmbPlcVO> fmbPlcVO = null;
			System.out.println("selectFmbPlcAlarm.do로 이동");
			try {
				//mBcfBizService : select, insert, delete, update 구문과 vo를 정형화 해놓음
				//
				//5. sql-bas-info.xml의  id가 selectFmbPlc인 select 실행
			
				fmbPlcVO = (List<FmbPlcVO>) mBcfBizService.select("sql-bas-info.selectFmbPlcAlarm",vo);
				 
				System.out.println("vo" +vo);
		/*		log.info(vo.getEqptCd());
				log.error(vo.getEqptCd());*/
				
				return new ResponseEntity<List<FmbPlcVO>>(fmbPlcVO, HttpStatus.OK);
				//7.응답받은 result 리턴
			} catch (Exception ie) {
				log.error("FmbPlcController:selectFmbPlc=>" +  ie.toString());
				return new ResponseEntity<List<FmbPlcVO>>(fmbPlcVO, HttpStatus.OK);
			}
		}
}
