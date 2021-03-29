package com.flo.alwaysbom.flower.service;

import com.flo.alwaysbom.flower.vo.FlowerVo;

import java.util.List;
import java.util.Optional;

public interface FlowerService {

    List<FlowerVo> findAll();

    Optional<FlowerVo> findByIdx(Integer idx);

}
