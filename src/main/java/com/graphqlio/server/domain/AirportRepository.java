/**
 * *****************************************************************************
 *
 * <p>Design and Development by msg Applied Technology Research Copyright (c) 2019-2020 msg systems
 * ag (http://www.msg-systems.com/) All Rights Reserved.
 *
 * <p>Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * <p>The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * <p>****************************************************************************
 */
package com.graphqlio.server.domain;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;
import java.util.Random;

@Component
public class AirportRepository {

  HashMap<String, Airport> repositoryMap = new HashMap<>();

  public AirportRepository() {
    Airport a = new Airport("MUC", "München");
    a.setId(new Random().nextLong());
    repositoryMap.put("MUC", a);

    Airport b = new Airport("FRA", "München");
    b.setId(new Random().nextLong());
    repositoryMap.put("FRA", b);
  }

  public Collection<Airport> findAll() {
    return repositoryMap.values();
  }

  public Optional<Airport> getByName(String name) {
    return Optional.ofNullable(repositoryMap.get(name));

  }

  public Airport save(Airport airport) {
    if (airport.getId() == null) {
      airport.setId(new Random().nextLong());
    }
    repositoryMap.put(airport.getName(), airport);
    return airport;
  }
}
